using System;

namespace Homeworks__2023
{
    internal class Exercise_2
    {
        static void Main(string[] args)
        {

            int max = 0;
            Console.WriteLine("Введите первое число");
            int number1 = int.Parse(Console.ReadLine());
            Console.WriteLine("Введите второе число");
            int number2 = int.Parse(Console.ReadLine());
            Console.WriteLine("Введите третье число");
            int number3 = int.Parse(Console.ReadLine());
            if (number1 > number2 & number1 > number3)
            { max = number1; }
            else if (number2 > number3 & number2 > number1)
            { max = number2; }
            else if (number3 > number1 & number3 > number2)
            { max = number3; }
            Console.WriteLine("Максимальное число: " + max);
            Console.ReadLine();
        }

    }
}
