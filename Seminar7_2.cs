using System;
using System.Data;

namespace Homeworks__2023
{
    internal class Seminar7_2
    {
        static int Prompt(string message)
        {
            Console.Write(message);

            int result = int.Parse(Console.ReadLine());
            return result;
        }
        static void PrintArray(int [,] array, int N, int M)

        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    Console.Write("{0,4}",array[i,j]);
                }
                Console.WriteLine();
            }
        }
        static int[,] GetArray(int N, int M, int minV, int maxV)
        {
            int [,] array = new int[N, M];

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    array[i, j] = new Random().Next(minV, maxV);

                }
            }
            return array;
        }
        static void YesOrNo(int[,]arr, int N, int M, int rowNumber, int columnNumber)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                   
                }
            }
            if (rowNumber > N | columnNumber > M)
                Console.WriteLine("Такого числа в массиве нет");
            else
                Console.WriteLine(arr[N - 1, M - 1]);
        }
        static void Main(string[] args)
        {

            int row = Prompt("Введите количество рядов: ");
            int column = Prompt("Введите количество столбцов: ");
            int minValue = Prompt("Введите минимальное значение: ");
            int maxValue = Prompt("Введите максимальное значение: ");

            int[,] a = GetArray(row, column, minValue, maxValue);

            PrintArray(a, row, column);
     
            int rowNumber  = Prompt("Введите номер ряда: ");
            int columnNumber = Prompt("Введите номер столбца: ");
           
            YesOrNo(a,row,column, rowNumber, columnNumber);
            Console.ReadLine();
        }
    
    }
}
