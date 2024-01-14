import java.util.Scanner;
import java.util.InputMismatchException;

interface HeadAndBodyAttri{
    //for head and body attributes...
    final String[] skinColors = {"White", "Black", "Fair", "Brown", "Gray"};
    final String[] faceShapes = {"Oval", "Round", "Square", "Heart", "Diamond"};
    final String[] eyeColors = {"Blue", "Browm", "Black", "Red", "Green"};
    final String[] noseShapes = {"Big", "Straight", "Roman", "Pango", "Button"};
    final String[] lipsShapes = {"Full Lips", "Thin Lips", "Heart Shaped Lips", "Heavy Lower Lips", "Notch"};
    final String[] earShapes = {"Pointy", "Round", "Square", "Broad Lobe", "Narrow"};
    final String[] hairStyles = {"Ponytail", "Wolf cut", "Apple cut", "Undercut", "Braids", "Two Block"};
    final String[] hairColors = {"Black", "White", "Blue", "Red", "Green"};
    final String[] bodyShapes = {"Underweight", "Lean", "Fit", "Masculine", "Overweight"};

    void setSkinColor();
    void setFaceShape();
    void setEyeColor();
    void setNoseShape();
    void setLipsShape();
    void setEarShape();
    void setHairStyle();
    void setHairColor();
    void setBodyShape();
}

interface OtherAttributes{
    //for other attributes...
    final String[] races = {"Human", "Elves", "Dwarf", "Undead", "Dragonoid"};
    final String[] jobs = {"Priest", "Knight/Warrior", "Thief", "Archer", "Merchant"};
    final String[] genders = {"Male", "Female", "Others", "Preferred not say", "Non-binary"};
    final String[] percentHeight = {"40%", "70%", "100%", "120%" };

    void setRace();
    void setJob();
    void setGender();
    void setHeight();
}

abstract class charBelongings{
    //for character's belongings
    final String[] outfits = {"Christmas Costume", "Formal Wear", "Combat Gear", "Valentines Costume", "Summer Outfit"};
    final String[] headGears = {"Helmet", "Head Band", "Tiara", "Cap", "Hijab"};
    final String[] pets = {"Dragon", "Phoenix", "Pegasus", "Wolf", "Mermaid"};

    abstract void setOutfit();
    abstract void setHeadgear();
    abstract void setPet();
}

abstract class Configuration extends charBelongings implements HeadAndBodyAttri, OtherAttributes{
    private String charName;//encapsulation~

//for setting character name...(encapsulation~)
    public void setName(String charName){
        this.charName = charName;
    }
//for getting character name...(encapsulation~)
    public String getName(){
        return charName.toUpperCase();
    }

//other features...
    int[] slots = {1, 2, 3, 4, 5};
    String[] modes = {"Story Mode", "Single Player", "Multiplayer", "Training Room", "Offline Mode"};
    String [] skills = {"Hp Regeneration", "Emergency Barrier", "Level Up Bonus", "Double Attack", "4 Leaf Clover"};
    abstract void charSlot();
    abstract void gameMod();
    abstract void setSkills();
}


class Customizing extends Configuration{
    String skinColor, faceShape, eyeColor, noseShape, lipsShape, earShape, 
    hairStyle, hairColor, bodyShape, race, job, gender, outfit, 
    headgear, pet, gameMod;
    static String passiveSkill;
    double height;
    int charSlot;

    Scanner input = new Scanner(System.in);

//to handle invalid choice...(method overload~)
    public boolean userSelection(){
        while(true){
            try {
                System.out.println("***Select '1' to view the game story, '2' to skip it.***");
                System.out.print("Enter your selection: ");
                int num = input.nextInt();
                if(num==1 || num==2){
                    if(num==1){
                        return true;
                    }
                    else{
                        return false;
                    }
                }
                else{
                    System.out.println("Invalid selected, try again\n");
                }
            } catch (Exception e) {
                System.out.println("Invalid selected, try again\n");
                input.next();
            }
        }
    } 
//to handle invalid choice...(method overload~)
    private int userSelection(String[] options, String title){
        int pickNum;
        while(true){
            try {
                System.out.println("\n----SELECT "+title+"----");
                for(int i=0; i<options.length; i++){
                    System.out.println("("+ (i+1) +") " + options[i]);
                }
                System.out.print("Enter your selection: ");
                pickNum = input.nextInt();
                if(pickNum>=1 && pickNum<=options.length){
                    break;
                }
                else{
                    System.out.println("Invalid choice, try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, try again.\n");
                input.next();
            }
        }
        return pickNum;
    }
//to handle invalid choice...(method overload~)
     private int userSelection(int[] options, String title){
        int pickNum;
        while(true){
            try {
                System.out.println("\n----SELECT "+title+"----");
                for(int i=0; i<options.length; i++){
                    System.out.println("("+ (i+1) +") slot " + options[i]);
                }
                System.out.print("Enter your selection: ");
                pickNum = input.nextInt();
                if(pickNum>=1 && pickNum<=options.length){
                    break;
                }
                else{
                    System.out.println("Invalid choice, try again.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice, try again.\n");
                input.next();
            }
        }
        return pickNum;
    }

//for setting Race...
    public void setRace(){
        String title = "RACE";
        int race = userSelection(races, title);
        this.race = races[race-1].toUpperCase();
        
    }
//for setting Job...
    public void setJob(){
        String title = "JOB";
        int job = userSelection(jobs, title);
        this.job = jobs[job-1].toUpperCase();
    }
//for setting Gender...
    public void setGender(){
        String title = "GENDER";
        int gender = userSelection(genders, title);
        this.gender = genders[gender-1].toUpperCase();
    }
//for setting Height...
    public void setHeight(){
        String title = "HEIGHT";
        int height = userSelection(percentHeight, title);
        switch(height){
            case 1:
            this.height = 0.4 * 178;
            break;
            case 2:
            this.height = 0.7 * 178;
            break;
            case 3: 
            this.height = 1.0 * 178;
            break;
            case 4:
            this.height = 1.2 * 178;
            break;
        }
    }

//for setting Skin Color...    
    public void setSkinColor(){
        String title = "SKIN COLOR";
        int skinColor = userSelection(skinColors, title);
        this.skinColor = skinColors[skinColor-1].toUpperCase();
    }
//for setting Face Shape...
    public void setFaceShape(){
        String title = "FACE SHAPE";
        int faceShape = userSelection(faceShapes, title);
        this.faceShape = faceShapes[faceShape-1].toUpperCase();
    }
//for setting Eye Color...
public void setEyeColor(){
    String title = "EYE COLOR";
    int eyeColor = userSelection(eyeColors, title);
    this.eyeColor = eyeColors[eyeColor-1].toUpperCase();
}
//for setting Nose Shape...
    public void setNoseShape(){
        String title = "NOSE SHAPE";
        int noseShape = userSelection(noseShapes, title);
        this.noseShape = noseShapes[noseShape-1].toUpperCase();
    }
//for setting Lips Shape...
    public void setLipsShape(){
        String title = "LIPS SHAPE";
        int lipsShape = userSelection(lipsShapes, title);
        this.lipsShape = lipsShapes[lipsShape-1].toUpperCase();
    }
//for setting Ear Shape...
    public void setEarShape(){
        String title = "EAR SHAPE";
        int earShape = userSelection(earShapes, title);
        this.earShape = earShapes[earShape-1].toUpperCase();
    }
//for setting Hair Style...
    public void setHairStyle(){
        String title = "HAIR STYLE";
        int hairStyle = userSelection(hairStyles, title);
        this.hairStyle = hairStyles[hairStyle-1].toUpperCase();
    }
//for setting Hair Color...
    public void setHairColor(){
        String title = "HAIR COLOR";
        int hairColor = userSelection(hairColors, title);
        this.hairColor = hairColors[hairColor-1].toUpperCase();
    }
//for setting Body Shape...
    public void setBodyShape(){
        String title = "BODY SHAPE";
        int bodyShape = userSelection(bodyShapes, title);
        this.bodyShape = bodyShapes[bodyShape-1].toUpperCase();
    }

//for setting Outfit...
    public void setOutfit(){
        String title = "OUTFIT";
        int outfit = userSelection(outfits, title);
        this.outfit = outfits[outfit-1].toUpperCase();
    }
//for setting headgear
    public void setHeadgear(){
        String title = "HEADGEAR";
        int headgear = userSelection(headGears, title);
        this.headgear = headGears[headgear-1].toUpperCase();
    }
//for setting pet...
    public void setPet(){
        String title = "PET";
        int pet = userSelection(pets, title);
        this.pet = pets[pet-1].toUpperCase();
    }

//for setting character slot...
    public void charSlot(){
        String title = "CHARACTER SLOT";
        int charSlot = userSelection(slots, title);
        this.charSlot = slots[charSlot-1];
    }
//for setting game mode...
    public void gameMod(){
        String title = "GAME MODE";
        int gameMod = userSelection(modes, title);
        this.gameMod = modes[gameMod-1].toUpperCase();
    }

//for setting passive skill...(method override)
    public void setSkills(){
        String title = "PASSIVE SKILL";
        int passiveSkillNum = userSelection(skills, title);
        passiveSkill = skills[passiveSkillNum-1].toUpperCase();
    }
}


public class MainCustomization extends Customizing{
    String gameStory = "Game Story:\r\n"
    		+ "In the mystical realm of Eternia, a land forged by ancient magic and inhabited by diverse races, an impending darkness threatens to engulf the world. \n"
    		+ "The balance between light and shadow hangs by a fragile thread, and only a chosen few can alter the course of fate.\r\n"
    		+ "\r\n"
    		+ "You, a budding adventurer, awaken with a blank slate—a canvas awaiting your artistic touch. As the land quivers under the weight of an approaching calamity, \n"
    		+ "you embark on a journey of self-discovery, customization, and heroic deeds.\r\n"
    		+ "\r\n"
    		+ "Eternia's fate lies in your hands. Uncover the secrets of your origin, shape your destiny with every choice, \n"
    		+ "and assemble a fellowship of companions to stand against the encroaching darkness. \n"
    		+ "Your journey will take you through enchanted forests, ancient ruins, and bustling cities, each harboring challenges and secrets.\r\n"
    		+ "\r\n"
    		+ "As you traverse this enchanting realm, your character's appearance, abilities, and affiliations will evolve based on your decisions. \n"
    		+ "Engage in epic battles, forge alliances, and delve into the rich lore that weaves the tapestry of Eternia.\r\n"
    		+ "\r\n"
    		+ "Will you rise as a legendary hero, a cunning rogue, or a wise mage? The story is yours to script, and the adventure awaits in MythicOdyssey.";
    String[] skillsDescript = new String[5];
    static String skillDescript;

    public MainCustomization(){
        skillsDescript[0] = "The character regenerates \n  5% of its HP every 5 seconds.";
        skillsDescript[1] = "When the character's HP \n  reaches 40%, it creates a \n  barrier that can negate an \n  enemy attack or skill.";
        skillsDescript[2] = "When a character levels up, \n  his or her HP and MP replenish.";
        skillsDescript[3] = "A double attack on an enemy \n  has a 35% chance of being successful.";
        skillsDescript[4] = "There is an additional 8% chance \n  that a monster or boss monster will \n  1drop a rare item.";
    }


//for setting skill Descript...(method override)
    public void setSkills(){
        for(int i=0; i<skills.length; i++){
            if(passiveSkill.equalsIgnoreCase(skills[i])){
                skillDescript = skillsDescript[i];
                break;
            }
        }
    }

    static Customizing setObj1 = new Customizing();
    static Customizing setObj2 = new MainCustomization();
    
    public void settings(){
        gameMod();
        charSlot();
        input.nextLine();
        System.out.print("\nEnter your character name: ");
        String charName = input.nextLine();
        setName(charName);
        setGender();
        setRace();
        setJob();
        setHeight();
        setBodyShape();
        setSkinColor();
        setFaceShape();
        setHairStyle();
        setHairColor();
        setHeadgear();
        setEyeColor();
        setEarShape();
        setNoseShape();
        setLipsShape();
        setOutfit();
        setPet();
        setObj1.setSkills();
        setObj2.setSkills();
    }

    public void displayCharacterInfo(){
        System.out.println("\n******************************"+
                           "\n|---CHARACTER'S BASIC INFO---|\n" +
                           "\n  Character Name : " + getName() + 
                           "\n  Gender         : " + gender + 
                           "\n  Height         : " + height +"cm"+
                           "\n  Race           : " + race +
                           "\n  Job            : " + job +
                           "\n\n|------BASIC ATTRIBUTES------|\n" +
                           "\n  Skin Color     : " + skinColor +
                           "\n  Face Shape     : " + faceShape +
                           "\n  Hair Style     : " + hairStyle +
                           "\n  Hair Color     : " + hairColor +
                           "\n  Eye Color      : " + eyeColor +
                           "\n  Nose Shape     : " + noseShape +
                           "\n  Lips Shape     : " + lipsShape +
                           "\n  Ear Shape      : " + earShape +
                           "\n  Body Shape     : " + bodyShape +
                           "\n\n|----------APPERANCE---------|\n" +
                           "\n  Headgear       : " + headgear +
                           "\n  Outfit/Costume : " + outfit +
                           "\n\n|---------COMPANION----------|\n" +
                           "\n  Pet            : " + pet + 
                           "\n\n|--------GAME DETAILS--------|\n" +
                           "\n  Game Mode      : " + gameMod + 
                           "\n  Character Slot : " + charSlot + 
                           "\n\n|--------PASSIVE SKILL-------|\n" +
                           "\n  "+passiveSkill+ ": \n- " + skillDescript + "\n");
    }
    

    public static void main(String[] args){
        MainCustomization mainObj = new MainCustomization();

        System.out.println("+---------------------------------------------+\n"+
                           "|                 WELCOME                     |"+
                         "\n|                                             |\n" +
                           "|                   TO                        |"+
                         "\n|                                             |\n" +
                           "|     MythicOdyssey: Tailor Your Legend       |\n"+
                           "+---------------------------------------------+");
        boolean viewStory = mainObj.userSelection();
        if(viewStory==true){
            System.out.println(mainObj.gameStory);
            mainObj.settings();
            mainObj.displayCharacterInfo();
        }
        else{
            mainObj.settings();
            mainObj.displayCharacterInfo();
        }
    }
}
