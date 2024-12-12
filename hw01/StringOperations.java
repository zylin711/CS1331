/*
    a) Create a new `String` object and assign it your name. Print it out.
    b) Pick the first letter in your name, and replace it with 'A'. Then, replace the last letter in your name with 'Z'. 
       Print out the result. Recall that, in Java, strings are *immutable*, meaning you cannot change a String in-place. 
       Do NOT just hard-code a new String with the first and last letters changed.
    c) Lastly, let's work with some URLs. Declare a new `String` and give it the value of some web address, in the 
       form `www.name.tld`, such as `www.gatech.edu` or `www.stackoverflow.com`. Print out this address.
    d) This last operation could be a little tricky. Create a substring of the variable that's just the "name" section, 
       and concatenate the integer "1331" to the end. For example, `www.gatech.edu` would become gatech1331. Print out this 
       final result. **Note**: the String class has a `.length()` method which you'll likely find useful here but is not necessary.
*/

public class StringOperations {
    public static void main(String[] args) {
        // a: Create a new String object with your name
        String name = "Elaine";
        System.out.println("Original Name: " + name);

        // b: Replace the first letter with 'A' and the last letter with 'Z'
        String firstReplaced = name.replace(name.charAt(0), 'A'); // Replace the first character
        char lastChar = name.charAt(name.length() - 1); // Get the last character
        String lastReplaced = firstReplaced.replace(lastChar, 'Z');  // Replace the last character
        System.out.println("Modified Name: " + lastReplaced);

        // c: Declare a new String with a web address and print it
        String webAddress = "www.stackoverflow.com";
        System.out.println("Web Address: " + webAddress);

        // d: Create a substring of the "name" section and concatenate "1331"
        String[] parts = webAddress.split("\\."); // Split the web address into parts
        String nameSection = parts[1]; // Extract "name" section
        String finalResult = nameSection.concat("1331"); // Concatenate the extracted name with "1331"
        System.out.println("Modified Web Address: " + finalResult);
    }
}
