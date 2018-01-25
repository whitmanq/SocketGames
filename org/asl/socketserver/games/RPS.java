package org.asl.socketserver.games;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.asl.socketserver.BestScore;
import org.asl.socketserver.MenuInfo;
import org.asl.socketserver.Servable;

@MenuInfo(authors = {
		"Quinn Whitman and Liam Hamama" }, version = "Spring 2018", title = "Rock, Scissors, Paper", description = "A Rock Paper Scissors game.")

public class RPS implements Servable {
	// sets 0 as initial value for user wins, computer wins and number of ties	
	
	// instance variables
	private int userWinCount = 0;
	private int computerWinCount = 0;
	private int numTies = 0;
	
	private int numGames;
	private int userChoice;
	private int computerChoice;

	public void serve(BufferedReader in, PrintWriter out) throws IOException {
		
		// TODO Auto-generated method stub
		
		// asks user for number of games that they want to play
		out.println("How many games?");
		numGames = Integer.parseInt(in.readLine());

		// for loop which repeats the game the desired number of times.
		for (int i = 1; i <= numGames; i++) {
			out.println("Game Number" + i);
			out.println("3=Rock...2=Scissors...1=Paper");

			// Gets user choice of rock paper or scissors
			out.println("1...2...3... What's your choice?");
			userChoice = Integer.parseInt(in.readLine());

			// if userChoice is greater than 3 or less than 1, print invalid
			if (userChoice > 3 || userChoice < 1) {
				out.println("Invalid");
			}

			// gets computer choice
			int max = 3;
			int min = 1;
			computerChoice = (int) (Math.random() * (max - min) + min);

			// shows computer choice to the reader
			if (computerChoice == 1) {
				out.println("This is my choice ... Paper!");
			} else if (computerChoice == 2) {
				out.println("This is my choice ... Scissors!");
			} else {
				out.println("This is my choice ... Rock!");
			}

			out.println("User CHOICE: " + userChoice + " & Comp CHOICE: " + computerChoice);

			// if user input and computer choice are the same
			if (computerChoice == userChoice) {
				out.println("It's a tie!");
				numTies += 1;
			} // rock beats scissors - computer wins
			else if (computerChoice == 3 && userChoice == 2) {
				out.println("WOW! I win!");
				computerWinCount += 1;
			} // scissors beats paper - computer wins
			else if (computerChoice == 2 && userChoice == 1) {
				out.println("WOW! I win!");
				computerWinCount += 1;
			} // paper beats rock - computer wins
			else if (computerChoice == 1 && userChoice == 3) {
				out.println("WOW!! I win!");
				computerWinCount += 1;
			} // rock beats scissors
			else if (userChoice == 3 && computerChoice == 2) {
				out.println("Congratulations!! You win!");
				userWinCount += 1;
			} // scissors beats paper
			else if (userChoice == 2 && computerChoice == 1) {
				out.println("Congratulations!! You win!");
				userWinCount += 1;
			} // paper beats rock
			else if (userChoice == 1 && computerChoice == 3) {
				out.println("Congratulations!! You win!");
				userWinCount += 1;
			} // if invalid, add 0
			else {
				out.println("Invalid");
				userWinCount += 0;
			}

		}

		out.println("Here is the final game score: \n I won " + computerWinCount + "\n You won " + userWinCount
				+ "\n And " + numTies + " ended in a tie.");

	}
}