import json

def select_to_parametr():
    while True:
        params = input("Введите параметр для поиска\n1 - поиск по id\n2 - поиск по названию заметки\n3 - поиск по дате\n0 - выход в меню\n")
        data = json.load(open("notes.json"))

        if params == "1":
            param = input("Введите id: ")
            for note in data['notes']:
                if note['id'] == int(param):
                    print(f"ID: {note['id']}\nЗаголовок: {note['title']}\nТекст: {note['body']}\nДата/Время: {note['timestamp']}\n") 
        elif params == "2":  
            param = input("Введите заголовок заметки: ")     
            for note in data['notes']:
                if note['title'] == param:
                    print(f"ID: {note['id']}\nЗаголовок: {note['title']}\nТекст: {note['body']}\nДата/Время: {note['timestamp']}\n")
        elif params == "3":
            param = input("Введите дату в формате ГГГГ-ММ-ДД: ")
            for note in data['notes']:     
                if note["timestamp"] == param:
                    print(f"ID: {note['id']}\nЗаголовок: {note['title']}\nТекст: {note['body']}\nДата/Время: {note['timestamp']}\n")
        elif params == "0":
            break
        else:
            print("Нет такой заметки!")

        


