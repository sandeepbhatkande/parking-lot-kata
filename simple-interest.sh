echo "Enter the Principle Amount: "
read p
echo "Enter the rate of interest: "
read r
echo "Enter the number of years: "
read n

i=`expr $p \* $r \* $n`
i=`expr $i / 100`
echo "The Simple Interest is :Rs.$i"
