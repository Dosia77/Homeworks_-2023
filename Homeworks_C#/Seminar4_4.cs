using System;

namespace Homeworks__2023
{
    internal class Seminar4_4
    {
        static void Power(ref int number1, ref int number2)
        {
            try
            {
                Console.WriteLine("Введите число: ");
                number1 = int.Parse(Console.ReadLine());
                Console.WriteLine("Введите степень, в которую нужно возвести число: ");
                number2 = int.Parse(Console.ReadLine());

            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода, необходим перезапуск. {exc.Message}");
                Console.ReadLine();
            }
            int pow = number1;
            for (int i = 0; i < number2 - 1; i++)
            { number1 = number1 * pow; }
            Console.WriteLine(number1);
            Console.ReadLine();
        }
        static void Sum(ref int number)
        {

            try
            {
                Console.WriteLine("Введите число: ");
                number = int.Parse(Console.ReadLine());
            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода, необходим перезапуск. {exc.Message}");
                Console.ReadLine();
            }
            int i = 0, sum = 0;
            while (number > 0)
            {
                sum = sum + number % 10;
                number = number / 10;
                i++;
            }
            Console.WriteLine(sum);
            Console.ReadLine();
        }

        public static void Main(string[] args)
        {
            int number1 = 0, number2 = 0, number = 0;

            Power(ref number1, ref number2);
            Sum(ref number);
            Random rand = new Random();
            for (int i = 0; i < 8; i++)
            {
                Console.Write("{0},", rand.Next(0, 8));

            }
            Console.ReadLine();

        }
    }
}
