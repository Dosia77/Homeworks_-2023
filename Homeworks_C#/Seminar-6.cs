using System;

namespace Homeworks__2023
{
    internal class Seminar_6
    {
        static double Request(string message)
        {
            Console.Write(message);
            double result = double.Parse(Console.ReadLine());
            return result;

        }
        static int[] InitMyArray(int N)
        {
            int[] myArray = new int[N];
            for (int i = 0; i < N; i++)
            {
                Console.Write($"Введите элемент {i}: ");
                myArray[i] = int.Parse(Console.ReadLine());
            }
            return myArray;
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
        static int CountNumbers(int[] mas)
        {
            int count = 0;
            for (int i = 0; i < mas.Length; i++)
            {
                if (mas[i] > 0)
                    count++;
            }
            return count;
        }
        static double PointX(double k1, double k2, double b1, double b2)
        {
            return -(b1 - b2) / (k1 - k2);
        }
        static double PointY(double k1, double b1, double x)
        {
            return k1 * x + b1;
        }
        static void Main(string[] args)
        {
            Console.Write("Введите длину массива: \t");
            int N = int.Parse(Console.ReadLine());
            int[] myArray = InitMyArray(N);

            PrintArray(myArray);
            Console.WriteLine("Количество чисел больше нуля в массиве: " + (CountNumbers(myArray)) + "\n");
            Console.ReadLine();

            double b1 = Request("Задайте значение b1: ");
            double k1 = Request("Задайте значение k1: ");
            double b2 = Request("Задайте значение b2: ");
            double k2 = Request("Задайте значение k2: ");
            double x = PointX(k1, k2, b1, b2);
            double y = PointY(k1, b1, x);

            Console.Write("Координаты пересечения двух прямых: (" + PointX(k1, k2, b1, b2) + "; " + PointY(k1, b1, x) + ")");
            Console.ReadLine();
        }
    }
}
