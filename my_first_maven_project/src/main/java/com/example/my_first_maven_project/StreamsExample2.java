package com.example.my_first_maven_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class StreamsExample2 {

	public static void main(String[] args) {
		List<String> aList = new ArrayList<String>();
		aList.add("Ashwin");
		aList.add("Akhira");
		aList.add("Swetha");
		aList.add("Ram");
		aList.add("Sita");
		aList.add("Siva");
		Long c = aList.stream().filter(s->s.startsWith("A")).count();
		System.out.println(c);
		long d = Stream.of("Jagan","Hari","Pavan","Bunty","Sandy").filter(s->
		{
			s.startsWith("P");
			return true;
		}).count();
		System.out.println(d);
		Stream.of("Jagan","Hari","Pavan","Bunty","Sandy").filter(s->s.length()==4).forEach(s->System.out.println(s));
		Stream.of("Jagan","Hari","Pavan","Bunty","Sandy").filter(s->s.length()==5).limit(2).forEach(s->System.out.println(s));
		Stream.of("Jagan","Hari","Pavan","Bunty","Sandy").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));
		List<String>names =Arrays.asList("Jagan","Jari","Pavan","Junty","Sandy");
		names.stream().filter(s->s.startsWith("J")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		//Merging 2 lists
		Stream<String> newStream = Stream.concat(aList.stream(), names.stream());
		newStream.sorted().forEach(s->System.out.println(s));
		//anyMatch method
		Stream<String> newStream2 = Stream.concat(aList.stream(), names.stream());
		boolean flag=newStream2.anyMatch(s->s.equalsIgnoreCase("siva"));
		System.out.println(flag);
		Assert.assertTrue(flag);
		List<String>ls =Stream.of("Jagan","Hari","Pavan","Bunty","Sandy").filter(s->s.endsWith("n")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(1));	
		List<Integer>values = Arrays.asList(3,2,2,5,5,7,8,4,9,1);
		values.stream().distinct().forEach(s->System.out.println(s));
		List<Integer>lst =values.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(lst.get(2));
	}
}
