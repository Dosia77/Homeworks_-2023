import json
from file_operation.sort import sort_id

def delete_note():
    note_id = input("Введите заголовок заметки, которую необходимо удалить: ")
    data = json.load(open("notes.json"))
    minimal = 0
    for txt in data['notes']:
        if txt['title'] == note_id:
            data['notes'].pop(minimal)
        else:
            print("Нет такой заметки")
        minimal = minimal+1   
    
    with open("notes.json", "w") as file:
        json.dump(data, file,indent=4, ensure_ascii=False )

    sort_id()

    print("Заметка удалена!")    
