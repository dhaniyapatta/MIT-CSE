echo "read a b and c"
read a b c

delta=`echo "($b * $b) - (4 * $a * $c)" | bc`

if [ $delta -lt 0 ]
then 
	val =1
else
	val=2
fi

root1=0
root2=0

case $val in
	"1")
de=`echo "-1 * $delta" | bc`
sq=`echo "scale=4;sqrt($de)" | bc`
