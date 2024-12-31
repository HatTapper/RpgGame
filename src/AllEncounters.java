// stores all encounters that the game uses

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

        Encounter encounter2 = new Encounter(2, """
                This one seems tough, you better think it through.
                """, new SewageBeast());

        Encounter encounter3 = new Encounter(3, """
                Your unintended nap was interrupted by the sound of growling and the patter of paws rapidly approaching.
                Instinctively, you leap to your feet. How long were you asleep? It's practically night...
                
                No matter, a hyena is rapidly approaching!
                """, new Hyena());

        this.encounters = new Encounter[]{encounter0, encounter1, encounter2, encounter3};
    }
}
