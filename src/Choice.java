public record Choice(String text, int encounterId, int nextPromptId) {
    public Choice(String text, int encounterId, int nextPromptId) {
        this.text = text;
        this.encounterId = encounterId;
        this.nextPromptId = nextPromptId;
    }
}
