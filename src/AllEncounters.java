public class AllEncounters {
    public Encounter[] encounters;

    public AllEncounters() {
        Encounter encounter0 = new Encounter(0, """
                Calling out for help, a faint squeak echoes in response.
                Out from the darkness, a sewer rat emerges!
                """, new Rat());
        Encounter encounter1 = new Encounter(1, """
                You force yourself to lay down on the damp floor, slowly entering the crawlspace.
                Unfortunately, it doesn't appear to go anywhere, with you reaching a dead end before
                even getting your entire body into the crawlspace.
                
                A rat suddenly squeezes out of a nearby hole, likely disturbed by your intrusion.
                """, new Rat());

        Encounter encounter2 = new Encounter(1, """
                This one seems tough, you better think it through.
                """, new SewageBeast());

        this.encounters = new Encounter[]{encounter0, encounter1, encounter2};
    }
}
