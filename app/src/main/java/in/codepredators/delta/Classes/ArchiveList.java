package in.codepredators.delta.Classes;

public class ArchiveList {
    public String archiveListName;
    public String textViewTimeOfMessageArchiveList;
    public ArchiveList() {
    }

    public ArchiveList(String archiveListName, String textViewTimeOfMessageArchiveList) {
        this.archiveListName = archiveListName;
        this.textViewTimeOfMessageArchiveList = textViewTimeOfMessageArchiveList;
    }

    public String getArchiveListName() {
        return archiveListName;
    }

    public void setArchiveListName(String archiveListName) {
        this.archiveListName = archiveListName;
    }

    public String getTextViewTimeOfMessageArchiveList() {
        return textViewTimeOfMessageArchiveList;
    }

    public void setTextViewTimeOfMessageArchiveList(String textViewTimeOfMessage) {
        this.textViewTimeOfMessageArchiveList = textViewTimeOfMessageArchiveList;
    }

}