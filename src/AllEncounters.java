public class AllEncounters {
    public Encounter[] encounters;

    public AllEncounters() {
        Encounter encounter0 = new Encounter(0, """
                Calling out for help, a faint squeak echoes in response.
                Out from the darkness, a sewer rat emerges!
                """, new Rat());

        this.encounters = new Encounter[]{encounter0};
    }
}
