using System;

namespace Homeworks__2023
{
    internal class Seminar7_1
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static void PrintArray(double[,] array, int N, int M)

        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    Console.Write("{0:F2}   ", array[i, j]);
                }
                Console.WriteLine();
            }
        }
        static double[,] GetArray(int N, int M)
        {
            double[,] array = new double[N, M];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    array[i, j] = new Random().NextDouble() * 100;

                }
            }
            return array;

        }

        static void Main(string[] args)
        {
            int row = Prompt("Введите количество рядов: ");
            int column = Prompt("Введите количество столбцов: ");
            double[,] a = GetArray(row, column);

            PrintArray(a, row, column);
            Console.ReadLine();
        }
    }
}
