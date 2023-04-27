# Java_Project2

### team_11_ingloriouscoders
This is students project for Java Technologies course

# Calculator API

## Usage
1. Start the application
2. Go to http://localhost:8080/calculator/calculateX?input=a,b,c (replace X with 1 or 2, replace a,b,c with numbers)
3. Be happy with response

## calculate1 endpoint returns:
1. Minimal odd number (*minOdd*)
2. Sum of even numbers (*sumOfEven*)
3. List of odd numbers (*odds*)

## calculate2 endpoint returns:
1. List of squared numbers (*squared*)
2. Sum of even numbers (*sumOfEven*)
3. Average of positive numbers (*averageOfPositives*)

## API request examples
1. Request: http://localhost:8080/calculator/calculate1?input=1,2,3,4,5
   Response: {"minOdd":1,"sumOfEven":6,"odds":[1,3,5]}
2. Request: http://localhost:8080/calculator/calculate1?input=1,99
   Response: {"minOdd":1,"sumOfEven": null,"odds":[1,99]}
3. Request: http://localhost:8080/calculator/calculate1?input=-2,0,4,12,-8
   Response: response: {"minOdd":null,"sumOfEven":6,"odds":null}
4. Request: http://localhost:8080/calculator/calculate1?input=0,5,2,3,8,10,4
   Response: {"minOdd":3,"sumOfEven":24,"odds":[5,3]}
5. Request:  http://localhost:8080/calculator/calculate2?input=-6,9,5,-1,8
   Response: {"squared":[36,81,25,1,64],"sumOfEven":2,"averageOfPositives":7.33}
6. Request: http://localhost:8080/calculator/calculate1?input=1,2,3
   Response: {"minOdd":1,"sumOfEven":2,"odds":[1,3]} 
7. Request: http://localhost:8080/calculator/calculate2?input=5,-2,1
   Response: {"squared":[25,4,1], "sumOfEven":-2, "averageOfPositives":3.00}