// stores all encounters that the game uses

public class AllEncounters {
    public Encounter[] encounters;
    public EncounterBoss boss;

    public AllEncounters() {
        Encounter encounter0 = new Encounter("""
                Calling out for help, a faint squeak echoes in response.
                Out from the darkness, a sewer rat emerges!
                """, new Rat());
        Encounter encounter1 = new Encounter("""
                You force yourself to lay down on the damp floor, slowly entering the crawlspace.
                Unfortunately, it doesn't appear to go anywhere, with you reaching a dead end before
                even getting your entire body into the crawlspace.
                
                A rat suddenly squeezes out of a nearby hole, likely disturbed by your intrusion.
                """, new Rat());

        Encounter encounter2 = new Encounter("""
                This one seems tough, you better think it through.
                """, new SewageBeast());

        Encounter encounter3 = new Encounter("""
                Your unintended nap was interrupted by the sound of growling and the patter of paws rapidly approaching.
                Instinctively, you leap to your feet. How long were you asleep? It's practically night...
                
                No matter, a hyena is rapidly approaching!
                """, new Hyena());

        Encounter encounter4 = new Encounter("", new Soldier());

        Encounter encounter5 = new Encounter("", new Knight());

        Encounter encounter6 = new Encounter("", new Hyena());

        Encounter encounter7 = new Encounter("", new KnightGroup());



        this.encounters = new Encounter[]{encounter0, encounter1, encounter2, encounter3, encounter4, encounter5,
                                          encounter6, encounter7};

        this.boss = new EncounterBoss("", new King());
    }
}
