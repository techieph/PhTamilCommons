# PhTamilCommons

## Dependency

### How to Use

To use ph-tamil-commons in your Maven project, you can add the following dependency to your project's pom.xml file:

```xml
<dependency>
    <groupId>com.ph.tamil.commons</groupId>
    <artifactId>ph-tamil-commons</artifactId>
    <version>LATEST</version>
</dependency>
```

This will work once the artifact is published to central maven repository.

### Building the Project

If you want to build the ph-tamil-commons library from source, you can use the following Maven command:

```
mvn clean install
```

This will compile the source code, run tests, and install the library into your local Maven repository.

### Contributions

Feel free to contribute to this project by reporting issues or submitting pull requests on this Github Repository.

### License

License
This project is licensed under the MIT License, so feel free to use, modify, and distribute it in your projects.

### TODO Items

- [x] Define Yen
- [x] Define Yen Basic Operations
- [x] Define Yezhluthu
- [x] Define Sol
- [ ] Ability to identify the Uyir and Mei from Uyirmei letters. Needed for Piritheluthu, Sertheluthu Implementations
- [ ] Ability to identify yethugai and monai between two Sol
- [ ] Define Sottrodar / Phrase (சொற்றொடர்)
- [ ] Define Vari (Line).
- [ ] Define Vaakiyam (Sentence)

## Table Of Contents
- [PhTamilCommons](#phtamilcommons)
- [Yen - Class](#yen---class)
    - [Yen - Different types of creating objects and comparing them](#yen---different-types-of-creating-objects-and-comparing-them)
- [YenBasicOperations - Class](#yenbasicoperations---class)
    - [YenBasicOperations - Different types of operations on Yen Object](#yenbasicoperations---different-types-of-operations-on-yen-object)
- [Yezhuthu - Class](#yezhuthu---class)
    - [Different ways to initialise](#different-ways-to-initialise)
    - [Comparing Objects with Different types of initialising](#comparing-objects-with-different-types-of-initialising)
    - [Sorting Array of Yezhuthu Objects - Normal Sorting](#sorting-array-of-yezhuthu-objects---normal-sorting)
    - [Sorting ArrayList of Yezhuthu Objects - Normal Sorting](#sorting-arraylist-of-yezhuthu-objects---normal-sorting)
    - [Sorting ArrayList of Yezhuthu Objects - Based on the Sound level (maathirai)](#sorting-arraylist-of-yezhuthu-objects---based-on-the-sound-level-maathirai)
    - [Sorting ArrayList of Yezhuthu Objects - Based on Yezhluthu Type (Uyir, Mei, UyirMei, Aayutham)](#sorting-arraylist-of-yezhuthu-objects---based-on-yezhluthu-type-uyir-mei-uyirmei-aayutham)
    - [Sorting ArrayList of Yezhuthu Objects - Based on Yezhluthu Constant Type (Valinam, Melinam, Idaiyinam, NotApplicable)](#sorting-arraylist-of-yezhuthu-objects---based-on-yezhluthu-constant-type-valinam-melinam-idaiyinam-notapplicable)
- [Sol - Class](#sol---class)
    - [Sol - Different types of creation and equals](#sol---different-types-of-creation-and-equals)
    - [Sol - Few other string methods in sol](#sol---few-other-string-methods-in-sol)
    - [Sol - Few types of sorting with Sol](#sol---few-types-of-sorting-with-sol)

## Yen - Class

### Yen - Different types of creating objects and comparing them

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYenException;
import com.ph.tamil.commons.types.Yen;

public class Driver {

    public static void main(String[] args) {
        try{
            Yen yen1 = new Yen("௩௪௫");
            Yen yen2 = new Yen(345);
            Yen yen3 = new Yen("-௩௪௫");
            Yen yen4 = new Yen(-345);
            Yen yen5 = new Yen("௧௨௬௭௮௯௦");
            Yen yen6 = new Yen(1267890);
            Yen yen7 = new Yen("-௧௨௬௭௮௯௦");
            Yen yen8 = new Yen(-1267890);
            if(yen1.equals(yen2)){
                System.out.println("Two objects of " + yen1.toInt() + "/" + yen1.toString() + " are equal");
            }
            if(yen3.equals(yen4)){
                System.out.println("Two objects of " + yen3.toInt() + "/" + yen3.toString() + " are equal");
            }
            if(yen5.equals(yen6)){
                System.out.println("Two objects of " + yen5.toInt() + "/" + yen5.toString() + " are equal");
            }
            if(yen7.equals(yen8)){
                System.out.println("Two objects of " + yen7.toInt() + "/" + yen7.toString() + " are equal");
            }
        } catch (InvalidYenException e) {
            System.out.println("InvalidYenException: " + e.getMessage());
        }
    }

}
```
```
Two objects of 345/௩௪௫ are equal
Two objects of -345/-௩௪௫ are equal
Two objects of 1267890/௧௨௬௭௮௯௦ are equal
Two objects of -1267890/-௧௨௬௭௮௯௦ are equal
```

### Yen - Few types of sortings

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYenException;
import com.ph.tamil.commons.types.Yen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        try{
            Yen[] yengal = new Yen[]{new Yen(12), new Yen(-12),new Yen("௬௭"), new Yen("-௭"), new Yen("௦")};
            Arrays.sort(yengal);
            System.out.println("Asc Sorted Array: " + Arrays.toString(yengal));
            Arrays.sort(yengal, Comparator.reverseOrder());
            System.out.println("Desc Sorted Array: " + Arrays.toString(yengal));
        } catch (InvalidYenException e) {
            System.out.println("InvalidYenException: " + e.getMessage());
        }
    }

}
```
```
Asc Sorted Array: [-௧௨, -௭, ௦, ௧௨, ௬௭]
Desc Sorted Array: [௬௭, ௧௨, ௦, -௭, -௧௨]
```

## YenBasicOperations - Class

### YenBasicOperations - Different types of operations on Yen Object

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYenException;
import com.ph.tamil.commons.operations.YenBasicOperations;
import com.ph.tamil.commons.types.Yen;

public class Driver {

    public static void main(String[] args) {
        try{
            Yen yen = new YenBasicOperations(new Yen("௧௨௩")) // 123
                    .kalithal(new Yen("௪௫")) // 45
                    .peruthal(new Yen(1)) // 1
                    .vaguthal(new Yen("-௨")) // -2
                    .end();
            System.out.println("Yen: " + yen.toInt() + "/" + yen);
        } catch (InvalidYenException e) {
            System.out.println("InvalidYenException: " + e.getMessage());
        }
    }

}
```
```
Yen: -39/-௩௯
```

## Yezhuthu - Class

### Different ways to initialise

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;
import java.util.Arrays;

public class Driver {

    static Yezhluthu[] yezhluthukal = new Yezhluthu[3];

    public static void main(String[] args) {
        try{
            // creating Yezhluthu from character
            yezhluthukal[0] = new Yezhluthu('ந');
            // creating Yezhluthu from string
            yezhluthukal[1] = new Yezhluthu("ஙூ");
            // creating Yezhluthu from yezhluthuIndex
            yezhluthukal[2] = new Yezhluthu(1);
            System.out.println("Yezhluthu Array: " + Arrays.toString(yezhluthukal));
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
    }

}
```
```
Yezhluthu Array: [ந, ஙூ, அ]
```

### Comparing Objects with Different types of initialising

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;

public class Driver {

    static Yezhluthu[] yezhluthukal = new Yezhluthu[3];

    public static void main(String[] args) {
        try{
            // creating Yezhluthu from character
            yezhluthukal[0] = new Yezhluthu('அ');
            // creating Yezhluthu from string
            yezhluthukal[1] = new Yezhluthu("அ");
            // creating Yezhluthu from yezhluthuIndex
            yezhluthukal[2] = new Yezhluthu(1);
            if(yezhluthukal[0].equals(yezhluthukal[1]) && yezhluthukal[1].equals(yezhluthukal[2])){
                System.out.println("All 3 objects are equal");
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
    }

}
```
```
All 3 objects are equal
```

### Sorting Array of Yezhuthu Objects - Normal Sorting

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;
import java.util.Arrays;

public class Driver {

    static Yezhluthu[] yezhluthukal = new Yezhluthu[10];
    static String[] tamilLetters  = {"இ","பூ","ஙௌ","ஆ","ர்","கீ","மா", "ஃ" ,"ரொ", "ஸொ"};

    public static void main(String[] args) {
        try{
            for(int i=0;i<tamilLetters.length;i++) {
                yezhluthukal[i] = new Yezhluthu(tamilLetters[i]);
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
        Arrays.sort(yezhluthukal);
        System.out.println("Sorted Array: " + Arrays.toString(yezhluthukal));
    }

}
```
```
Sorted Array: [ஆ, இ, ர், கீ, ஙௌ, பூ, மா, ரொ, ஸொ, ஃ]
```

### Sorting ArrayList of Yezhuthu Objects - Normal Sorting

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;

import java.util.*;

public class Driver {

    static List<Yezhluthu> yezhluthuList = new ArrayList<>();
    static String[] tamilLetters  = {"இ","பூ","ஙௌ","ஆ","ர்","கீ","மா", "ஃ" ,"ரொ", "ஸொ"};

    public static void main(String[] args) {
        try{
            for(int i=0;i<tamilLetters.length;i++) {
                yezhluthuList.add(new Yezhluthu(tamilLetters[i]));
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
        Collections.sort(yezhluthuList);
        System.out.println("Sorted Array: " + yezhluthuList.toString());
    }

}
```
```
Sorted Array: [ஆ, இ, ர், கீ, ஙௌ, பூ, மா, ரொ, ஸொ, ஃ]
```

### Sorting ArrayList of Yezhuthu Objects - Based on the Sound level (maathirai)

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;

import java.util.*;

public class Driver {

    static List<Yezhluthu> yezhluthuList = new ArrayList<>();
    static String[] tamilLetters  = {"இ","பூ","ஙௌ","ஆ","ர்","கீ","மா", "ஃ" ,"ரொ", "ஸொ"};

    public static void main(String[] args) {
        try{
            for(int i=0;i<tamilLetters.length;i++) {
                yezhluthuList.add(new Yezhluthu(tamilLetters[i]));
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
        yezhluthuList.sort(Comparator.comparing((Yezhluthu y) -> y.getYezhluthuDetails().getYezhluthuSoundType().getYezhluthuSoundLevel()));
        System.out.println("Sorted Array: " + yezhluthuList.toString());
    }

}
```
```
Sorted Array: [ர், ஃ, இ, ரொ, ஸொ, பூ, ஙௌ, ஆ, கீ, மா]
```

### Sorting ArrayList of Yezhuthu Objects - Based on Yezhluthu Type (Uyir, Mei, UyirMei, Aayutham)

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;

import java.util.*;

public class Driver {

    static List<Yezhluthu> yezhluthuList = new ArrayList<>();
    static String[] tamilLetters  = {"இ","பூ","ஙௌ","ஆ","ர்","கீ","மா", "ஃ" ,"ரொ", "ஸொ"};

    public static void main(String[] args) {
        try{
            for(int i=0;i<tamilLetters.length;i++) {
                yezhluthuList.add(new Yezhluthu(tamilLetters[i]));
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
        yezhluthuList.sort(Comparator.comparing((Yezhluthu y) -> y.getYezhluthuDetails().getYezhluthuType()));
        System.out.println("Sorted Array: " + yezhluthuList.toString());
    }

}
```
```
Sorted Array: [இ, ஆ, ர், பூ, ஙௌ, கீ, மா, ரொ, ஸொ, ஃ]
```

### Sorting ArrayList of Yezhuthu Objects - Based on Yezhluthu Constant Type (Valinam, Melinam, Idaiyinam, NotApplicable)

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Yezhluthu;

import java.util.*;

public class Driver {

    static List<Yezhluthu> yezhluthuList = new ArrayList<>();
    static String[] tamilLetters  = {"இ","பூ","ஙௌ","ஆ","ர்","கீ","மா", "ஃ" ,"ரொ", "ஸொ"};

    public static void main(String[] args) {
        try{
            for(int i=0;i<tamilLetters.length;i++) {
                yezhluthuList.add(new Yezhluthu(tamilLetters[i]));
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
        yezhluthuList.sort(Comparator.comparing((Yezhluthu y) -> y.getYezhluthuDetails().getYezhluthuConstantType()));
        System.out.println("Sorted Array: " + yezhluthuList.toString());
    }

}
```
```
Sorted Array: [பூ, கீ, ஙௌ, மா, ரொ, இ, ஆ, ர், ஃ, ஸொ]
```

## Sol - Class

### Sol - Different types of creation and equals

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Sol;
import com.ph.tamil.commons.types.Yezhluthu;

import java.util.Collections;

public class Driver {

    public static void main(String[] args) {
        try{
            Sol sol1 = new Sol("ஆ");
            Sol sol2 = new Sol('ஆ');
            Yezhluthu yezhluthu = new Yezhluthu(2);
            Sol sol3 = new Sol(Collections.singletonList(yezhluthu));
            if(sol1.equals(sol2) && sol2.equals(sol3)) {
                System.out.println("Sol1, Sol2 and Sol3 are equal");
                System.out.println("This sol is " + sol1.toString() + " and has length " + sol1.length());
            }
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
    }

}
```
```
Sol1, Sol2 and Sol3 are equal
This sol is ஆ and has length 1
```

### Sol - Few other string methods in sol

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Sol;
import com.ph.tamil.commons.types.Yezhluthu;

public class Driver {

    public static void main(String[] args) {
        try{
            Sol sol = new Sol("காத்திருந்தான்");
            sol.replace(new Yezhluthu("ன்"),new Yezhluthu("ள்"));
            System.out.println("காத்திருந்தான் is replaced to " + sol.toString());
            System.out.println("காத்திருந்தாள் starts with காத்தி is " + sol.startsWith(new Sol("காத்தி")));
            System.out.println("காத்திருந்தாள் starts with த்திருந் is " + sol.startsWith(new Sol("த்திருந்")));
            System.out.println("காத்திருந்தாள் ends with தாள் is " + sol.endsWith(new Sol("தாள்")));
            System.out.println("காத்திருந்தாள் ends with ருந்தா is " + sol.endsWith(new Sol("ருந்தா")));
            System.out.println("காத்திருந்தாள் subSol from index 1 is " + sol.subSol(1));
            System.out.println("காத்திருந்தாள் subSol from index 1 to index 4 is " + sol.subSol(1,4));
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
    }

}
```
```
காத்திருந்தாள் is replaced to காத்திருந்தாள்
காத்திருந்தாள் starts with காத்தி is true
காத்திருந்தாள் starts with த்திருந் is false
காத்திருந்தாள் ends with தாள் is true
காத்திருந்தாள் ends with ருந்தா is false
காத்திருந்தாள் subSol from index 1 is த்திருந்தாள்
காத்திருந்தாள் subSol from index 1 to index 4 is த்திரு
```

### Sol - Few types of sorting with Sol

```java
package com.ph.tamil.commons.drivers;

import com.ph.tamil.commons.exception.InvalidYezhluthuException;
import com.ph.tamil.commons.types.Sol;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        try{
            List<Sol> solList = new ArrayList<>();
            solList.add(new Sol("தீப்தி"));
            solList.add(new Sol("எழிலரசன்"));
            solList.add(new Sol("இயலிசை"));
            solList.add(new Sol("குமரவேல்"));
            solList.add(new Sol("மதி"));
            Collections.sort(solList);
            System.out.println("Asc Order: " + solList.toString() );
            solList.sort(Comparator.reverseOrder());
            System.out.println("Desc Order: " + solList.toString());
            solList.sort(Comparator.comparing((Sol sol)-> sol.length()));
            System.out.println("Length Asc Order: "+ solList.toString());
        } catch (InvalidYezhluthuException e) {
            System.out.println("InvalidYezhluthuException: " + e.getMessage());
        }
    }

}
```
```
Asc Order: [இயலிசை, எழிலரசன், குமரவேல், தீப்தி, மதி]
Desc Order: [மதி, தீப்தி, குமரவேல், எழிலரசன், இயலிசை]
Length Asc Order: [மதி, தீப்தி, இயலிசை, குமரவேல், எழிலரசன்]
```
