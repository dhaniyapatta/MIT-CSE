echo "Read a number"

read number 

x=0
y=1

while [ $x -lt $number ]
do
	x=$((x+1))
	y=`echo "$x * $y" | bc`
done

echo "the Factorial of $number is: $y"
