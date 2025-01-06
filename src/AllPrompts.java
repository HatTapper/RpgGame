
/*
this class contains all the prompts used by the game
 */

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
               
               You check your pockets for anything that might be useful, and you find a pouch holding 10 silver coins.
               Well, at least you have some money...
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

        choice0 = new Choice("Set out for the village.", -1, 19);
        Prompt Prompt13 = new Prompt("""
                It's far too late to be staying out here. You need to get to the village as soon as possible.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Go to the inn.", -1, 15);
        choice1 = new Choice("Go to the shop.", -1, 16);
        choice2 = new Choice("Go to the library.", -1, 20);
        Prompt Prompt14 = new Prompt("""
                Upon reaching the village, you can see the bustle of people walking around. Nobody seems to pay any mind
                to your presence. Apart from a bunch of what looks like normal houses, you spot a few buildings that
                you could check out.
                """, new Choice[]{choice0, choice1, choice2}, 6, emptyFunc);

        choice0 = new Choice("Wait for the owner.", -1, 19);
        choice1 = new Choice("Go to the shop.", -1, 16);
        choice2 = new Choice("Go to the library.", -1, 20);
        Prompt Prompt15 = new Prompt("""
                Inside the inn, you see a desk with a sign hanging from the front of it.
                
                "5 SILVER PER NIGHT"
                
                You suddenly remember the pouch of money you had in your pocket. You look around for anyone that appeared
                to be the owner of the inn, but nobody seems to be there. You could wait for the owner to show up, but
                you'd miss out on exploring the rest of the village if you did.
                """, new Choice[]{choice0, choice1, choice2}, 6, emptyFunc);

        choice0 = new Choice("Buy the sword (-5 silver)", -1, 17);
        choice1 = new Choice("Buy the shield (-5 silver)", -1, 18);
        Prompt Prompt16 = new Prompt("""
                You're greeted warmly by the shopkeeper who quickly recognizes you as a stranger. You scan the shelves
                for anything you could make use of.
                
                There is a sword hanging from the wall. It looks to be of decent quality and would surely be better
                than your fists.
                
                On a table, you can see a wooden shield lined with steel. That would give you a chance to defend yourself.
                
                Pulling out your pouch, you check the prices again. Seeing that inns don't tend to be free, you decide that
                you'll have to pick between the two options such that you'll still have 5 silver left over for the inn.
                """, new Choice[]{choice0, choice1, choice2}, 6, emptyFunc);

        choice0 = new Choice("Go to the inn.", -1, 19);
        Prompt Prompt17 = new Prompt("""
                Nice, a new weapon. You put it in your inventory and continue on your way. It seems to be getting late.
                You should go to the inn.
                """, new Choice[]{choice0}, 6,
                new PromptFunction[]{new WeaponPromptFunction(new Sword()), new DefensePromptFunction(3), new MoneyPromptFunction(-5), new SkillPromptFunction(new SkillDoubleHit())});

        choice0 = new Choice("Go to the inn.", -1, 19);
        Prompt Prompt18 = new Prompt("""
                Nice, a new shield. You put it in your inventory and continue on your way. It seems to be getting late.
                You should go to the inn.
                """, new Choice[]{choice0}, 6,
                new PromptFunction[]{new DefensePromptFunction(10), new MoneyPromptFunction(-5), new SkillPromptFunction(new SkillParry())});

        choice0 = new Choice("Sleep.", -1, 21);
        Prompt Prompt19 = new Prompt("""
                You pay the 5 silver coin cost to take a room for the night at the inn. You enter the room and
                immediately collapse onto the soft mattress. After everything that's been going on today, you feel refreshed and
                just want to sleep. You'll figure out what to do tomorrow.
                """, new Choice[]{choice0}, 6,
                new PromptFunction[]{new MoneyPromptFunction(-5), new HealthPromptFunction(999)});

        choice0 = new Choice("Go to the inn.", -1, 19);
        Prompt Prompt20 = new Prompt("""
                The library seems to be entirely empty. Well, of people. There's no lack of books. You take a look at
                one of them that appears to be about battle tactics. Some of the stuff in here actually makes a lot of sense...
                The book offers countless tips and tricks on defending yourself in battle, even delving into healing magic!
                
                After you finally manage to take your eyes off the words, you realize it's gotten late. Well, at least
                you spent your time doing something productive before going to the inn...
                """, new Choice[]{choice0}, 6,
                new PromptFunction[]{new DamagePromptFunction(5), new DefensePromptFunction(5), new SkillPromptFunction(new SkillHeal())});

        choice0 = new Choice("Fight.", 4, 22);
        Prompt Prompt21 = new Prompt("""
                You wake up to hear the sound of screaming, orders being shouted, and the clinking of armor.
                Rubbing sleep out of your eyes, you get out of bed and quickly stand up.
                
                'No time to hesitate,' you say to yourself as your words quickly become truth due to an armored soldier
                bursting through the door to your room almost immediately after. You have no clue what vendetta they have
                against you, but it's time to fight.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Fight.", 4, 23);
        Prompt Prompt22 = new Prompt("""
                As soon as one falls, another one charges forward, clearly dead-set on finishing you off.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Fight.", 5, 24);
        Prompt Prompt23 = new Prompt("""
                This one falls, another one approaches. This guy looks different. The armored knight steps up to you coldly,
                raising his great sword. You take a deep breath, feeling like you could take on anything in this moment.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Figure out what to do next.", -1, 25);
        Prompt Prompt24 = new Prompt("""
                The knight topples to the ground. You walk past their body and head outside. You can see
                that the soldiers ransacked the entire village. The library was set aflame and bodies of soldiers and
                villagers alike were spread across the ground. The remaining soldiers saw the fallen knight behind you
                and swiftly decided to retreat. Strange.
                
                The remaining villagers came out of their homes, spotting the remnants of your battle. The knight must've
                been the leader of this attack, as the villagers praise and cheer. The innkeeper hurriedly steps out
                behind you and returns you the money you spent on the room last night. Other villagers hand you money and
                gifts as well. You feel stronger.
                """, new Choice[]{choice0}, 6, new PromptFunction[]{new ExperiencePromptFunction(1000), new MoneyPromptFunction(100)});

        choice0 = new Choice("Set out for the castle.", -1, 26);
        Prompt Prompt25 = new Prompt("""
                You ask the villagers about who those soldiers were, and where they came from. You learn that the kingdom
                of Gaurde has a king that went rogue and ordered the destruction of everyone who opposed him. This village
                appeared to be in the middle of the crossfire. You're not sure if the king had any good reason to be doing
                this, but wreaking such destruction doesn't make any sense if it were for a good cause. You decided that
                you were going to go take on the king and defeat him in battle.
                
                The villagers cheered your resolution, wishing you good luck for your journey.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Fight.", 6, 27);
        Prompt Prompt26 = new Prompt("""
                Not long after you leave the village, a hyena ambushes you in broad daylight! Time to test your skill.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Continue!", -1, 28);
        Prompt Prompt27 = new Prompt("""
                Wow, that fight felt incredibly easy. You look at yourself with a newfound confidence as you continue
                traveling down the barren path to the kingdom of Gaurde.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Purchase the great sword.", -1, 29);
        choice1 = new Choice("Purchase the dagger.", -1, 30);
        choice2 = new Choice("I don't need either of them!", -1, 31);
        Prompt Prompt28 = new Prompt("""
                As you see the castle looming in the distance, you find a merchant's cart stopped along the path. Seeing
                as you have a lot of money, you go to check it out.
                
                Inside the cart the merchant shows you a wide selection of items. A few of them stand out to you:
                
                A skill book denoting an ancient technique which allows the caster to pierce the defenses of their enemies.
                
                A great sword etched with magical runes to increase the damage output of the wielder.
                
                A small, nimble dagger marked with dry blood.
                
                You purchase the skill book for 10 silver, leaving you with either the sword or dagger which both cost 50
                silver each.
                """, new Choice[]{choice0, choice1, choice2}, 6, new PromptFunction[]{new MoneyPromptFunction(-10)});

        choice0 = new Choice("Continue.", -1, 32);
        Prompt Prompt29 = new Prompt("""
                You leave the shop with your new sword. The weight will take some getting used to, but you can feel the
                sheer power it holds.
                """, new Choice[]{choice0}, 6, new PromptFunction[]{new WeaponPromptFunction(new Greatsword()), new SkillPromptFunction(new SkillPierce()), new SkillPromptFunction(new SkillWarcry()), new MoneyPromptFunction(-50)});

        choice0 = new Choice("Continue.", -1, 32);
        Prompt Prompt30 = new Prompt("""
                You leave the shop with your new dagger. It feels light in your hands and seems to hold vampiric powers
                within.
                """, new Choice[]{choice0}, 6, new PromptFunction[]{new WeaponPromptFunction(new Dagger()), new SkillPromptFunction(new SkillPierce()), new SkillPromptFunction(new SkillVampiricSlash()), new MoneyPromptFunction(-50)});

        choice0 = new Choice("Continue.", -1, 33);
        Prompt Prompt31 = new Prompt("""
                Yeah, who needs super powerful magical weapons anyway? You leave with just the skill book.
                """, new Choice[]{choice0}, 6, new PromptFunction[]{new SkillPromptFunction(new SkillPierce())});

        choice0 = new Choice("Well, about that... *quickly attack the knight*", 5, 34);
        Prompt Prompt32 = new Prompt("""
                You finally reach the castle. Its imposing size makes you step back for a moment. You can see a large
                building past the main gate, with a grand path leading to it. That must be where the king resides...
                
                Lost in thought, a blade in front of you jolts you out of your mind, a knight confronting you. He says
                that no unauthorized visitors are allowed into the kingdom at this time, and you need to show the
                necessary documentation.
                
                Shoot, if only you had some money left over, you could bribe him... You awkwardly show the small amount
                of money you have. He doesn't acknowledge it and simply asks again for the necessary documentation.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Well, about that... *quickly attack the knight*", 5, 34);
        choice1 = new Choice("Would this change your mind? (-60 silver)", -1, 36);
        Prompt Prompt33 = new Prompt("""
                You finally reach the castle. Its imposing size makes you step back for a moment. You can see a large
                building past the main gate, with a grand path leading to it. That must be where the king resides...
                
                Lost in thought, a blade in front of you jolts you out of your mind, a knight confronting you. He says
                that no unauthorized visitors are allowed into the kingdom at this time, and you need to show the
                necessary documentation.
                
                Hmm, what to do...
                """, new Choice[]{choice0, choice1}, 6, emptyFunc);

        choice0 = new Choice("Next fight.", 7, 35);
        Prompt Prompt34 = new Prompt("""
                Ah great, now you've gone and done it. A lot of guards are coming, better get ready.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Face the king.", -1, 37);
        Prompt Prompt35 = new Prompt("""
                You take a deep breath as the last knight topples to the ground. That was a lot of work. However, it seems
                like you've scared off the rest from attacking you, and you've secured a clear path to the king.
                
                You begin heading to the large building straight ahead. Inside, you can see a carpeted path that appears
                to lead directly to the throne room, its entrance shrouded by curtains.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Face the king.", -1, 37);
        Prompt Prompt36 = new Prompt("""
                The knight you bribed leads you inside. Grateful for the easy entrance, you begin heading to the large
                building straight ahead. Inside, you can see a carpeted path that appears to lead directly to the throne
                room, its entrance shrouded by curtains.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Take on the king!", -1, 38);
        Prompt Prompt37 = new Prompt("""
                You see the king on his throne. He remains silent, his head hung low under the weight of his crown. His
                armor glitters in the sunlight and almost looks like it vibrates the air surrounding it. Without saying
                a word, he rises to face you, drawing a battle axe honed with the souls of thousands.
                
                Seeing how incredibly antagonistic he is, you're glad that you decided to fight him. You smirk, knowing
                that this battle will be the toughest you've faced yet. And you wouldn't have it any other way.
                """, new Choice[]{choice0}, 6, emptyFunc);

        choice0 = new Choice("Take on the king!", -1, 38);
        Prompt Prompt38 = new Prompt("""
                You see the king on his throne. He remains silent, his head hung low under the weight of his crown. His
                armor glitters in the sunlight and almost looks like it vibrates the air surrounding it. Without saying
                a word, he rises to face you, drawing a battle axe honed with the souls of thousands.
                
                Seeing how incredibly antagonistic he is, you're glad that you decided to fight him. You smirk, knowing
                that this battle will be the toughest you've faced yet. And you wouldn't have it any other way.
                """, new Choice[]{choice0}, 6, emptyFunc);


        // structure to store all the prompts to be accessed by the prompt manager later on
        this.prompts = new Prompt[]
                {
                        Prompt0, Prompt1, Prompt2, Prompt3, Prompt4, Prompt5,
                        Prompt6, Prompt7, Prompt8, Prompt9, Prompt10, Prompt11,
                        Prompt12, Prompt13, Prompt14, Prompt15, Prompt16, Prompt17,
                        Prompt18, Prompt19, Prompt20, Prompt21, Prompt22, Prompt23,
                        Prompt24, Prompt25, Prompt26, Prompt27, Prompt28, Prompt29,
                        Prompt30, Prompt31, Prompt32, Prompt33, Prompt34, Prompt35,
                        Prompt36, Prompt37, Prompt38,
                };
    }

    public AllPrompts()
    {
        loadText();
    }
}
