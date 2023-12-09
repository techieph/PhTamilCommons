# PhTamilCommons

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
All 3 objects are equal
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

### Sorting Array of Yezhuthu Objects - Different ways to initialise

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

### Sorting Array of Yezhuthu Objects - Comparing Objects with Different types of initialising

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
