class Induvidual:
    def __init__(self,Charecter_name):
        self.name = Charecter_name
        
def main():
    a= get_charecter_name()
    induvidual = Induvidual("Boster")
    induvidual2 = Induvidual("Tobias")
    print(induvidual.name)
    print(induvidual2.name)
if __name__ == "__main__":
    main()
