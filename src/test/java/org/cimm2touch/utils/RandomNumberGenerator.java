package org.cimm2touch.utils;

import java.util.Random;

public class RandomNumberGenerator {
	
public static int generateRandomNumber()
{
	Random random = new Random();
	int randomNumber = random.nextInt();		
    return randomNumber;
}

public static int generateEightRandomNumbers() {
	// TODO Auto-generated method stub
	Random rnd = new Random();
	int n = 1000000 + rnd.nextInt(9900000);
	return n;
}

public static char generateCharacters(){
	 Random r = new Random();
	 char c = (char)(r.nextInt(26) + 'a');
	 return c;
	}
}
