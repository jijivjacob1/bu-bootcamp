import java.io.*; 
import java.util.ArrayList;

 
public class GradeAnalyzer {
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        // ArrayList<Integer> scores = new ArrayList<>(List.of(10, 20, 30));
        int[] invalidLines = new int[1]; // Index 0 will hold our count
        int linesSkipped =0;
        


       // invaidlines checkinvalidlines = new invalidLines();
        ArrayList<Integer> scores = readScores("scores.txt",invalidLines);

       // System.out.println("Number of Invalid lines: " + invalidLines[0]);

       linesSkipped = invalidLines[0];
   
        // Step 2: calculate statistics
        double average_score = calculateAverage(scores);
       // System.out.println("Average score is: " + average_score);

        int highest_score = Integer.MIN_VALUE;
        int lowest_score = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score < lowest_score ) lowest_score = score;
            if (score > highest_score ) highest_score = score;
        }

     //   System.out.println("Highest score is: " + highest_score);
     //   System.out.println("Lowest score is: " + lowest_score);

        
       
        // Step 3: write and print report
        writeReport(scores,average_score,highest_score,lowest_score,linesSkipped,"grade_report");
        
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename,int[] invalidLines) {
        // your code here
         String line="";
         int value=0;
         int numlinesSkipped =0;
         ArrayList<Integer> scores = new ArrayList<>();
 
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty())
                {
                    System.out.println("Skipping empty line: ");
                    invalidLines[0]++;;
                    continue;
                }
                try{
                    value = Integer.parseInt(line);
                }
                catch (NumberFormatException e) {
                
                    System.out.println("Skipping invalid value: " + line);
                    invalidLines[0]++;;
                    continue;
                }
                scores.add(value);
            }

            
        }
        catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }
        
        catch (Exception e) {
            System.out.println("Genereal Exception : " + e.getMessage());
        }

 
     //   System.out.println("Number of Invalid lines: " + invalidLines[0]);
        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        double total_score = 0.0;
        double average_score = 0.0;

        if (scores.isEmpty()) return total_score;

        for (int score : scores) {
            total_score += score;
        }

        average_score = total_score / scores.size();

        return average_score;
    } 
 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,int linesSkipped,
                                  String outputFile) {

        //Grade bands: A = 90+, B = 80 to 89, C = 70 to 79, D = 60 to 69, F = below 60. 
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score > 90) {
                countA ++;
            }
            else if(score >= 80 && score <= 89){
                countB ++;
            }
            else if(score >= 70 && score <= 79){
                countC ++;
            }
            else if(score >= 60 && score <= 69){
                countD ++;
            }
            else
                countF ++;

        }
        // System.out.println("countA is: " + countA);
        // System.out.println("countB is: " + countB);
        // System.out.println("countC is: " + countC);
        // System.out.println("countD is: " + countD);
        // System.out.println("countF is: " + countF);
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
           
            System.out.println("=== Grade Analysis Report ===");
            writer.write( "=== Grade Analysis Report ===");
            writer.newLine();
            System.out.println("Total scores processed: " + scores.size());
            writer.write("Total scores processed: " + scores.size());
            writer.newLine();
            System.out.println("Invalid lines skipped: " + linesSkipped);
            writer.write("Invalid lines skipped: " + linesSkipped);
            writer.newLine();
            writer.newLine();
            System.out.println("");
            System.out.println("");
            System.out.println(String.format("Average score: %.2f", avg));
            writer.write(String.format("Average score: %.2f", avg));
            writer.newLine();
            System.out.println("Highest score: " + high);
            writer.write("Highest score: " + high);
            writer.newLine();
            System.out.println("Lowest score: " + low);
            writer.write("Lowest score: " + low);
            writer.newLine();
            writer.newLine();
            System.out.println("");
            System.out.println("");
            System.out.println("Grade distribution: " );
            writer.write("Grade distribution: ");
            writer.newLine();
            System.out.println("  A (90-100): " + String.format("%5d",countA));
            writer.write("  A (90-100): " + String.format("%5d",countA));
            writer.newLine();
            System.out.println("  B (80-89): " + String.format("%6d",countB));
            writer.write("  B (80-89): " + String.format("%6d",countB));
            writer.newLine();
            System.out.println("  C (70-79): " + String.format("%6d",countC));
            writer.write("  C (70-79): " + String.format("%6d",countC));
            writer.newLine();
            System.out.println("  D (60-69): " + String.format("%6d",countD));
            writer.write("  D (60-69): " + String.format("%6d",countD));
            writer.newLine();
            System.out.println("  F (below 60): " + String.format("%3d",countF));
            writer.write("  F (below 60): " + String.format("%3d",countF));
            writer.newLine();
           

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 
