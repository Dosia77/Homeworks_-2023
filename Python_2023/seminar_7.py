print()
print('Задача про Винни-Пуха')
print()

c = []
a = (input('введите сопелку  ')).split()

for i in range(len(a)):
    c.append(len(list(filter(lambda x: x in 'аоеиёыуэюя', a[i]))))
   
print((lambda x: 'Парам пам-пам' if len(set(x)) == 1 else 'Пам парам')(c))


print()
print('Функция print_operation_table')
print()

def print_operation_table(operation, num_rows=6, num_columns=6):
    arr = [[operation(i, j) for j in range(1, num_columns + 1)] for i in range(1, num_rows + 1)]
    for i in arr:
        print(*[f"{x:>3}" for x in i])

print_operation_table(lambda x, y: x * y)


