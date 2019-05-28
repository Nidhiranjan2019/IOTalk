package in.codepredators.delta.Classes;

public class Code {
    public String codeMessageSender;
    public String codeMessageReceiver;
    public String codeMessagetextView;
    public String codeTimeOfMessagetextView;
    public Code() {
    }

    public Code(String codeMessageSender, String codeMessageReceiver, String codeMessagetextView, String codeTimeOfMessagetextView) {
        this.codeMessageSender=codeMessageSender;
        this.codeMessageReceiver=codeMessageReceiver;
        this.codeMessagetextView=codeMessagetextView;
        this.codeTimeOfMessagetextView=codeTimeOfMessagetextView;

    }

    public String getcodeMessageSender() {
        return codeMessageSender;
    }

    public void setcodeMessageSender(String codeMessageSender) {
        this.codeMessageSender = codeMessageSender;
    }

    public String getcodeMessageReceiver() {
        return codeMessageReceiver;
    }

    public void setcodeMessageReceiver(String codeMessageReceiver) {
        this.codeMessageReceiver = codeMessageReceiver;
    }

    public String getcodeMessagetextView() {
        return codeMessagetextView;
    }

    public void setcodeMessagetextView(String codeMessagetextView) {
        this.codeMessagetextView = codeMessagetextView;
    }

    public String getcodeTimeOfMessagetextView() {
        return codeTimeOfMessagetextView;
    }

    public void codeTimeOfMessagetextView(String codeTimeOfMessagetextView) {
        this.codeTimeOfMessagetextView = codeTimeOfMessagetextView;
    }

}