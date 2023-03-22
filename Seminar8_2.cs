using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Homeworks__2023
{
    internal class Seminar8_2
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static int[,] GetArray(int N, int M)
        {
            int[,] a = new int[N, M];

            Random rand = new Random();
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    a[i, j] = rand.Next(0, 10);

                }
            }
            return a;

        }
        static void Print(int[,] arr, int n, int m)
        {
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write(arr[i, j]);
                }
                Console.WriteLine();
            }
        }
        static int[] SumRow(int[,] arr, int N, int M)
        {
            int[] S = new int[N];
            for (int i = 0; i < N; i++)
            {
                S[i] = 0;
                for (int j = 0; j < M; j++)
                { S[i] = S[i] + arr[i, j]; }
            }
            return S;
        }
        static void MinSumRow(int[] Sum, int N)
        {
            int min = Sum[0]; int numberMinRow = 0;
            for (int i = 1; i < N; i++)
            {
                if (Sum[i] < min) { min = Sum[i]; numberMinRow = i; }
            }
            Console.Write("Минимальный ряд номер: {0}, сумма элементов в ряду {1}", (numberMinRow + 1), min);

        }
        static void Main(string[] args)
        {
            int n = Prompt("Введите количество рядов: ");
            int m = Prompt("Введите количество столбцов: ");
            int[,] a = GetArray(n, m);
            Print(a, n, m);

            int[] S = SumRow(a, n, m);
            MinSumRow(S, n);

            Console.ReadLine();


        }
    }
}
