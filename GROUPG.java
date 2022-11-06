package com.projectG;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class GROUPG {
	public static int scoreCount = 0;

	public static void main(String[] args) {
		PreparedStatement prepared = null;
		String sqlQuery = null;
		Scanner sc = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/Prime?characterEncoding=utf8";
			Connection con = DriverManager.getConnection(url, "root", "root");

			sc = new Scanner(System.in);
			System.out.println("\t\t\t--*-*-*-*-Welcome To MCQ QUiz-*-*-*-*--\n" + "\n" + "\tEnter Your Details:-->");
			System.out.print("\t\tId-->>");
			int id = sc.nextInt();
			
			if(id!=)
			System.out.print("\t\tName:->>");
			sc.nextLine();
			String name = sc.nextLine();

			prepared = con.prepareStatement("Select * ,rand() as random_value from  Question order by rand()");

			System.out.println("\t\t---x-x-x-x-x-Quiz Start-x-x-x-x---\n");

			ResultSet rst = prepared.executeQuery();

			while (rst.next()) {

				System.out.println("\t\t" + rst.getString(1) + "\n" + "\t\t" + rst.getString(2) + "\n" + "\t\t"
						+ (rst.getString(3) + "\n" + "\t\t" + (rst.getString(4) + "\n") + "\t\t" + rst.getString(5)));
				String ans = rst.getString(6);

				sc = new Scanner(System.in);

				System.out.print("\t\t\t>>>>>>>Select Your Answer~-~-~-~>");
			
				String str = sc.next();
			
				System.out.println("\t\t\t\tYour Typed Ans is--->>" + str + "\n");

				if (str.equals(ans)) {
					System.out.println("\t\t\t\t-------- It's Correct--" + ans + "--------" + "\n");

					scoreCount++;

				} else {
					System.out.println("\t\t\t\t~~~ It's Wrong~~~\n");
				}

				System.out.print("\t\t\t\t------Are You Interested to continue the Quiz---------->Y/N" + "\t\t\t\t");
				Scanner sc2 = new Scanner(System.in);
				
				String y = sc2.nextLine();
				String s = "Y";

				if (y.equals(s)) {
					System.out.println("\t\t\t\t\t---------------------Next Question>>>>>\n");

				} else {
					System.out.println("\t\t\tYour Quiz is Stop");
				}

			}

			System.out.println("\t\t\t\t\t*~*~--Your Score is-->>" + scoreCount);
			sqlQuery = "insert into Score(id,name,score) values (?,?,?)";
			prepared = con.prepareStatement(sqlQuery);

			prepared.setInt(1, id);
			prepared.setString(2, name);
			prepared.setInt(3, scoreCount);
			int a = prepared.executeUpdate();

			if (scoreCount > 8 && scoreCount <= 10) {
				System.out.println("\t\t\t\tClass A-->");
			} else if (scoreCount > 6 && scoreCount <= 8) {
				System.out.println("\t\t\t\tClass B-->");
			} else if (scoreCount == 5) {
				System.out.println("\t\t\t\tClass C-->");
			} else if (scoreCount < 5) {
				System.out.println("\n\t\t\t\t\t-x-x-- You Are Failed--x-x");

			}

			System.out.println("\t\t\t\t------------Are You Interested To Show Student Data--------->>>Yes/No");
			Scanner sc1 = new Scanner(System.in);

			System.out.print("\t\t\t\t\tPlease Enter---->>>");
			String yt = sc1.nextLine();

			String Yes = "Yes";
			if (yt.equals(Yes)) {
				StdDipsplay.getConnection();
			} else {
				System.out.println("\t\t\t\t-------Your Quiz is Succesfully Completed---------\n" + "\n"
						+ "\t\t\t\t-x-x-x---Thank You-x-x-x-");
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

}