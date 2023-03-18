using System;

namespace Homeworks__2023
{
    internal class Seminar5_3
    {
        static void PrintArray(double[] array)
        {
            Console.Write("[");
            for (int i = 0; i < array.Length - 1; i++)
            {
                Console.Write($"{array[i]}, ");
            }
            Console.Write($"{array[array.Length - 1]}");
            Console.WriteLine("]");
        }
        static int RequestDouble(string message)
        {
            Console.Write(message);
            int result = int.Parse(Console.ReadLine());
            return result;

        }
        static double[] DoubleArray(int length)
        {
            double[] mas = new double[length];
            Random r = new Random();
            for (int i = 0; i < mas.Length; i++)
            {
                mas[i] = r.NextDouble();

            }
            return mas;
        }
        static void ExcessBetweenMaxAndMin(double[] mas)
        {

            double min = mas[0];
            double max = mas[0];
            for (int i = 1; i < mas.Length; i++)
            {
                if (mas[i] > max) { max = mas[i]; }
                if (mas[i] < min) { min = mas[i]; }
            }
            double res = max - min;
            Console.Write("Разница между максимальным и минимальным элементами: {0:F2}", res);

        }
        static void Main(string[] args)
        {
            // задача # 38

            int length = RequestDouble("Задайте длину массива: ");
            double[] arrayDouble = DoubleArray(length);

            PrintArray(arrayDouble);
            ExcessBetweenMaxAndMin(arrayDouble);

            Console.ReadLine();


        }
    }
}
