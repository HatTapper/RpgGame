


public class AllPrompts {
    public Prompt[] prompts;

    private void loadText()
    {
        PromptFunction[] emptyFunc = new PromptFunction[]{new EmptyPromptFunction()};

        Choice choice0 = new Choice("Search your surroundings.", -1, 1);
        Choice choice1 = new Choice("Call for help.", 0, 2);
        Choice choice2 = new Choice("PLACEHOLDER DO NOT USE WITHOUT REDEFINING", -1, -1);
        Choice choice3 = new Choice("PLACEHOLDER DO NOT USE WITHOUT REDEFINING", -1, -1);

        Prompt Prompt0 = new Prompt("""
               You open your eyes, the smell of rot invading your nostrils.
               As your blurry vision adjusts to the dank setting, you find yourself inside a sewage system,
               the only source of light being sun rays peeking through the gutter above you.
               \s
               With what feeble strength you can muster, you force yourself to sit up and scan your surroundings.
               Apart from the obvious issues prevalent in a bacteria-ridden sewage system, no other threats are apparent.
               \s
               A sudden wave of pain flashes across your head and your hand instinctively reaches up to rub against your forehead.
               Trying to remember what could have possibly led you here only made your head hurt more.
               \s
               You go through your possible options:
               
               (Tip: To make a choice, enter the corresponding number next to the option.
               To quit, enter "q".
               To view your stats at any time, enter "stats".)
               \s""", new Choice[]{choice0, choice1}, 0, emptyFunc);

        choice0 = new Choice("Put your hand inside the sewage water.", -1, 3);
        choice1 = new Choice("Give up looking for something.", -1, 0);
        Prompt Prompt1 = new Prompt("""
               Of course, there's bound to be something someone threw into this sewage.
               You try to scan the damp concrete floor, feeling along the ground for anything you can grab.
               The dim lighting makes it difficult, and you ultimately can't find anything useful.
               
               Your gaze drifts toward the viscous sewage water, a stagnant current gently flowing along who knows what.
               \s""", new Choice[]{choice0, choice1}, 1, emptyFunc);

        choice0 = new Choice("Continue", -1, 4);
        Prompt Prompt2 = new Prompt("""
               Ew, you didn't think rats were that big. Plus it had, like, disgusting stuff sticking out of its fur.
               As the rat draws its final breath, you try not to think too hard about struggling against a mere rodent.
               \s""", new Choice[]{choice0}, 2, emptyFunc);

        choice0 = new Choice("Continue", -1, 4);
        Prompt Prompt3 = new Prompt("""
               Steeling yourself for the inevitable diseases you're going to contract from this, you take a deep breath
               and insert your hand inside the water.
               
               Lo and behold, there was nothing inside the "water" but a sense of lingering disappointment in yourself.
               You store your disappointment in your inventory and continue. Your hand stings, but it feels stronger??
               \s""", new Choice[]{choice0}, 3, new PromptFunction[]{new HealthPromptFunction(-10), new DamagePromptFunction(3)} );

        choice0 = new Choice("Travel down the crawlspace.", 1, 5);
        choice1 = new Choice("Continue down the main path.", -1, 6);
        Prompt Prompt4 = new Prompt("""
                You begin to travel down the sewage system tunnel.
                
                Running your hand along the slick concrete wall, your fingers suddenly catch along a divot in the wall.
                Upon investigation, there appears to be a crawlspace. It's far too dark to see anything in there.
                """, new Choice[]{choice0, choice1}, 4, emptyFunc);

        choice0 = new Choice("Continue down the main path.", -1, 6);
        Prompt Prompt5 = new Prompt("""
                You hate rats.
                
                Either way, you're sure that the combat experience will come in handy for the future
                when you finally break free from this sewer.
                """, new Choice[]{choice0}, 5, emptyFunc);
        choice0 = new Choice("Stand up!", 2, 7);
        Prompt Prompt6 = new Prompt("""
                You've likely been traveling down this tunnel for nearly an hour. Your legs are tired and you're
                starting to reach the end of your patience. Suddenly, you spot a ladder which leads up to a metal hatch
                in the ceiling. This must be your ticket out of here!
                
                A little careless as a result of how long you've been down here, you quickly bolt for the ladder.
                Suddenly, your feet skid on a puddle of the sewage water at the foot of the ladder, making you crash to
                the ground with a bang that reverberates through the entire tunnel. Shoot.
                
                Taking a deep breath, your brief recovery is interrupted as the sounds of sloshing water can be heard
                behind you. Turning your head, you see a figure emerge from the sewer water, covered in debris and
                dripping sewage.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Begin walking to the village.", -1, 14);
        choice1 = new Choice("This is too scary, go back down the hatch.", -1, 9);
        choice2 = new Choice("Bask in the sun.", -1, 8);
        Prompt Prompt7 = new Prompt("""
                OH, FINALLY. You open the hatch and feel a cool breeze waft by. Taking in a deep whiff of the fresh, crisp air,
                you climb the rest of the way out and look around. Strange. You appear to be far from any sort of civilization.
                Apart from a small village in the distance, all you can see is grass and a distant, thick forest.
                
                It seems to be the middle of the day, so you have plenty of time to figure out what to do next.
                """, new Choice[]{choice0, choice1, choice2}, 6, emptyFunc);

        choice0 = new Choice("Keep basking in the sun.", -1, 11);
        choice1 = new Choice("Begin walking to the village.", -1, 14);
        Prompt Prompt8 = new Prompt("""
                Yea, you deserve this break after what you just went through.
                
                You lay your back against the grass, closing your eyes as you listen to the sound of the breeze
                brushing against the grass. Serene.
                """, new Choice[]{choice0, choice1}, 6, emptyFunc);

        choice0 = new Choice("Begin walking to the village.", -1, 14);
        choice1 = new Choice("Bask in the sun.", -1, 8);
        Prompt Prompt9 = new Prompt("""
                No. You aren't going back down there.
                """, new Choice[]{choice0, choice1}, 6, emptyFunc);

        Prompt Prompt10 = new Prompt("""
                This will display when the user wants to go to the village.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Zzz...", 3, 13);
        choice1 = new Choice("No! Fight sleep!", -1, 12);
        Prompt Prompt11 = new Prompt("""
                You've got all the time in the world, right? Might as well enjoy it while you can.
                
                Ah, the sun feels so nice, so warm...
                You feel yourself start to drift off...
                """, new Choice[]{choice0, choice1}, 6, emptyFunc);

        choice0 = new Choice("Set out for the village.", -1, 14);
        Prompt Prompt12 = new Prompt("""
                "No!" you cry out as you slap yourself across the face. Ow.
                """, new Choice[]{choice0}, 6, new PromptFunction[]{new HealthPromptFunction(-1)});

        choice0 = new Choice("Set out for the village.", -1, 14);
        Prompt Prompt13 = new Prompt("""
                It's far too late to be staying out here. You need to get to the village as soon as possible.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("placeholder text", -1, 14);
        Prompt Prompt14 = new Prompt("""
                END OF TEST
                """, new Choice[]{choice0}, 6, emptyFunc);


        this.prompts = new Prompt[]
                {
                        Prompt0, Prompt1, Prompt2, Prompt3, Prompt4, Prompt5,
                        Prompt6, Prompt7, Prompt8, Prompt9, Prompt10, Prompt11,
                        Prompt12, Prompt13, Prompt14
                };
    }

    public AllPrompts()
    {
        loadText();
    }
}
