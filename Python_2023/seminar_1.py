print('Сумма цифр трехзначного числа')

print("Введите трёхзначное число: ")
a = int(input())
#
# a = 123
b=a//100
c=a%100//10
d=a%10
e = b+c+d
print(f"{a}->{e}({b}+{c}+{d})")

print('Задача про журавликов')

countBirds = 60
katya = (countBirds//3)*2
petyaSergey = katya//4

print(f"{countBirds} -> {petyaSergey} {katya} {petyaSergey}")

print('Счастливый билетик')

ticketNumber = input("Введитe шестизначный номер билетика: ");
if int(ticketNumber[0])+int(ticketNumber[1])+int(ticketNumber[2]) == int(ticketNumber[3])+int(ticketNumber[4])+int(ticketNumber[5]):
    print("Yes")
else:
    print("No")

print('Делим шоколадку')

n = int(input("Введите размер шоколадки n "))
m = int(input("Введите размер шоколадки m "))
k = int(input("Введите количество долек k "))

if (k < m*n) and (k%m==0 or k%n==0):
    print(f"{n} {m} {k} -> Yes")
else:
    print(f"{n} {m} {k} -> No")





 
