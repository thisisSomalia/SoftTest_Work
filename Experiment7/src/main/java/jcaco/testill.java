package jcaco;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class testill {
   private illindex index;
   private Scanner scanner;


    private LinkedList<illindex> ill;
   private LinkedList<illindex> illtest;

    public void setIlltest(LinkedList<illindex> illtest) {
        this.illtest = illtest;
    }

    public void readfromtxt(){
       illtest=new LinkedList<illindex>();
       ill=new LinkedList<illindex>();
       String path1="D:\\intellij存放\\softwaretest\\ex4\\ill.txt";
       String path2="D:\\intellij存放\\softwaretest\\ex4\\illtest.txt";
       File file1 = new File(path1);
       File file2 = new File(path2);
       try {
           InputStreamReader inputStreamReader1=new InputStreamReader(new FileInputStream(file1));
           InputStreamReader inputStreamReader2=new InputStreamReader(new FileInputStream(file2));
           BufferedReader reader1 =new BufferedReader(inputStreamReader1);
           BufferedReader reader2 =new BufferedReader(inputStreamReader2);
           String str;
           int i=0;
           while ((str=reader1.readLine())!=null){
                //index.setAnswer(scanner.nextL
                index=new illindex();
                index.setIndex(i);
                index.setQusetion(str);
                ill.add(index);
                i++;
           }
           reader1.close();
           inputStreamReader1.close();
           i=0;
           while ((str=reader2.readLine())!=null){
               index=new illindex();
               index.setIndex(i);
               index.setQusetion(str);
               illtest.add(index);
               i++;
           }
           reader2.close();
           inputStreamReader2.close();



       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       //testlink(illtest);

   }

   public void testlink(LinkedList<illindex> ill){
       for (int i=0;i<ill.size();i++) {
           System.out.println(ill.get(i).toString());
       }

   }

   public int test(){
       for (int i=0;i<illtest.size();i++) {
           System.out.println(illtest.get(i).getQusetion());
           scanner=new Scanner(System.in);
           String s = scanner.nextLine();
           illtest.get(i).setAnswer(s);
           if( i ==0 && s.contains("A")){
               for(int j=0;j<ill.size();j++){
                   System.out.println(ill.get(j).getQusetion());
                   scanner=new Scanner(System.in);
                   ill.get(i).setAnswer(scanner.nextLine());
               }
           }
       }

       return 0;
   }

   public int resultint(){
       int count=0;
       if(illtest.getFirst().getAnswer().contains("A")){
          if(!illtest.getLast().getAnswer().contains("E")){
              count=1;
          }else count=2;
       }
       if(!illtest.getFirst().getAnswer().contains("A")){
           if(illtest.getLast().getAnswer().contains("E")){
              count=4;
           }else count=3;
       }
       return count;
   }

   public String result(int re){
       switch (re){
           case 1:
               return "建议立刻发热门诊就诊，并且佩戴好口罩做好防护。佩戴医用外科口罩或N95口罩，避免乘坐公共交通工具。";
           case 2:
               return "结合你提供的病情症状及接触史特点，建议继续在家监测体温，可适当服用治疗感冒的中成药，注意手卫生，多饮水，休息为主。若体温持续不退或体温大于38℃或不适症状加重，及时就诊。";
           case 3:
               return "建议你们全家及密切接触者居家隔离至少2周，在家期间建议戴口罩交流，条件允许时，尽量单独居住或居住在通风良好的单人房间。\n" +
                       "多休息，多饮水，注意手卫生和常用物品卫生消毒。若出现发热及呼吸道症状，需马上前往医院就诊。\n";
           case 4:
               return "建议您戴口罩、勤洗手，避免人群聚集，减少不必要外出。";
           default:
               break;

       }

       return "";
   }

   public static void main(String args[]){
       testill test=new testill();
       test.readfromtxt();
       test.test();
       int result=test.resultint();
       System.out.println(test.result(result));
   }
}
