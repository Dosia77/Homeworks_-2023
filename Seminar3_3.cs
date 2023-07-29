using System;

namespace Homeworks__2023
{
    internal class Seminar3_3
    {
        //        Задача 23
        //Напишите программу, которая принимает на вход число(N) и выдаёт таблицу кубов чисел от 1 до N.
        //3 -> 1, 8, 27
        //5 -> 1, 8, 27, 64, 125


        static void Cubes(ref int num)
        {
            Console.WriteLine("Задача #23");
            try
            {
                Console.WriteLine("Введите число: ");
                num = int.Parse(Console.ReadLine());
            }
            catch (Exception exc)
            {
                Console.WriteLine($"Ошибка ввода {exc.Message}"); return;
            }
            for (int i = 1; i <= num; i++)
                Console.WriteLine(i * i * i);
        }
        public static void Main(string[] args)
        {


            
            int num = 0;

            

            Cubes(ref num);

            Console.ReadLine();
        }
    }
}
