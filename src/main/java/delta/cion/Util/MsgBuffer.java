package delta.cion.Util;

public class MsgBuffer {
    private final StringBuffer buffer = new StringBuffer();


    public void bufAppend(String s) {
        buffer.append(s).append("\n");
    }

    public void bufClear() {
        this.buffer.setLength(0);
    }

    public String getMessage() {
        if (buffer.isEmpty() || buffer.charAt(buffer.length()) == '\n') return "Contact with Dev. No Message :(";

        buffer.deleteCharAt(buffer.length() - 1);
        return this.buffer.toString();
    }
}
