import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Demo{
  public static void main(String[] args) throws Exception {
    String[] cmds = args[0].split(",");

    for (String cmd : cmds) {
      System.out.println(cmd);
      System.out.println("---command result start---");
      System.out.print(executeCommand(cmd.trim()));
      System.out.println("---command result end---");
    }
  }

  private static String executeCommand(String command) {
    StringBuilder output = new StringBuilder();

    try {
      Process p = Runtime.getRuntime().exec(command);
      p.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

      String line;
      while ((line = reader.readLine()) != null) {
        output.append(line).append("\n");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return output.toString();
  }
}