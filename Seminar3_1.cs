using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar3_1
    {
        static void Palindrom(ref int n)

        {
            // Задача 19
            //            Напишите программу, которая принимает на вход пятизначное число и проверяет, является ли оно палиндромом.
            //14212->нет
            //12821->да
            //23432->да

            Console.WriteLine("Задача # 19");
            try
            {
                Console.Write("Введите пятизначное число: ");
                n = int.Parse(Console.ReadLine());
            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода, начинай сначала!{exc.Message}");
                return;

            }

            if (n % 10 == n / 10000 && (n / 1000) % 10 == (n / 10) % 10)
                Console.WriteLine("Да");
            else
                Console.WriteLine("Нет");
            Console.ReadLine();
        }

        static void Main(string[] args)
        {
            int n = 0;
            Palindrom(ref n);

            Console.ReadLine() ;
        }
    }
}
