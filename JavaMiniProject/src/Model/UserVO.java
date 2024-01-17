package Model;

public class UserVO {
   
   private String id;
   private String pw;
   private String name;
   private int age;
   
   private double valance;
   
   public UserVO(String id, String pw, String name, int age) {
      this.id = id;
      this.pw = pw;
      this.name = name;
      this.age = age;
   }
   
   public UserVO(String id, String pw) {
      this.id = id;
      this.pw = pw;      
   }
   
   public UserVO(String id) {
      this.id = id;
   }

   public String getId() {
      return id;
   }

   public String getPw() {
      return pw;
   }

   public String getName() {
      return name;
   }

   public int getAge() {
      return age;
   }

   public double getValance() {
      return valance;
   }
   
   
}