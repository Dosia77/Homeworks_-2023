using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;




namespace Homeworks__2023
{
    internal class Seminar5_2
    {
        static int Request(string message)
        {
            Console.Write(message);
            int result = int.Parse(Console.ReadLine());
            return result;

        }
        static void PrintArray(int[] array)
        {
            Console.Write("[");
            for (int i = 0; i < array.Length - 1; i++)
            {
                Console.Write($"{array[i]}, ");
            }
            Console.Write($"{array[array.Length - 1]}");
            Console.WriteLine("]");
        }
        static int[] IntArray(int length, int min, int max)
        {
            int[] mas = new int[length];
            Random r = new Random();
            for (int i = 0; i < length; i++)
            {
                mas[i] = r.Next(min, max);

            }
            return mas;
        }
        static void SumOdd(int[] mas)
        {
            int sum = 0;
            for (int i = 0; i < mas.Length; i++)
            {
                if (i == 1 || i % 2 != 0)
                    sum = sum + mas[i];
            }
            Console.Write("Сумма элементов на нечётных позициях равна: {0}", sum);

        }
        static void Main(string[] args)
        {
            // Задача # 36

            int length = Request("Задайте длину массива: ");
            int min = Request("Начальное значение для диапозона массива случайных чисел: ");
            int max = Request("Конечное значение для диапозона массива случайных чисел: ");
            int[] array = IntArray(length, min, max);

            PrintArray(array);
            SumOdd(array);
            Console.ReadLine();
        }
    }
}
