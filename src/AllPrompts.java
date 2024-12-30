import java.util.Map;

public class AllPrompts {
    public Prompt[] prompts;

    private void loadText()
    {
        Choice choice0 = new Choice("Search your surroundings.", -1, 1);
        Choice choice1 = new Choice("Call for help.", 0, 2);
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
               \s""", new Choice[]{choice0, choice1}, 0);

        choice0 = new Choice("Put your hand inside the sewage water.", -1, 3);
        choice1 = new Choice("Give up looking for something.", -1, 0);
        Prompt Prompt1 = new Prompt("""
               Of course, there's bound to be something someone threw into this sewage.
               You try to scan the damp concrete floor, feeling along the ground for anything you can grab.
               The dim lighting makes it difficult, and you ultimately can't find anything useful.
               
               Your gaze drifts toward the viscous sewage water, a stagnant current gently flowing along who knows what.
               \s""", new Choice[]{choice0, choice1}, 1);

        choice0 = new Choice("Continue", -1, 3);
        Prompt Prompt2 = new Prompt("""
               Ew, you didn't think rats were that big. Plus it had, like, disgusting stuff sticking out of its fur.
               As the rat draws its final breath, you try not to think too hard about struggling against a mere rodent.
               \s""", new Choice[]{choice0}, 2);

        choice0 = new Choice("Continue", -1, 3);
        Prompt Prompt3 = new Prompt("""
               Steeling yourself for the inevitable diseases you're going to contract from this, you take a deep breath
               and insert your hand inside the water.
               
               
               Lo and behold, there was nothing inside the "water". You store your disappointment in your inventory and
               continue.
               \s""", new Choice[]{choice0}, 3);


        this.prompts = new Prompt[]{Prompt0, Prompt1, Prompt2};
    }

    public AllPrompts()
    {
        loadText();
    }
}
