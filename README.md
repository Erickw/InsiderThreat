# InsiderThreat
 * @authors Erick Willy and Tyrone Damasceno 
 * @version infoVersão: Alpha 1.0
 
Como utilizar o sistema:

Para utilizar a aplicação deve-se primeiramente abrir os arquivos a serem lidos, devem ser estes: Um arquivo referente a lista de usuários e seus atributos, com extensão
.CSV e um arquivo referente a lista de atividades dos usuarios, com também, seus respectivos atributos. Caso os arquivos não tenham sido abertos e lidos primordiamente, as demais funcionalidades
do programa não funcionarão corretamente, uma vez que não há dados para ler.

-> Lendo e processando os arquivos:

1) Clique em "Abrir e Processar Arquivos".
2) Insira o diretório do arquivo dos usuários no primeiro campo de texto.
3) Insira o diretório do arquivo das atividades dos usuários no segundo campo de texto.
4) Clique em OK 
5) Você Receberá uma mensagem de sucesso, caso os arquivos sejam lidos corretamente. Caso contrário, feche a janela aberta, verifique o caminho do arquivo e tente novamente.
   Exemplo de caminho de arquivo: /home/SeuNome/Documentos/Arquivos/ldap.csv
   
-> Buscando e visualizando usuários por ID:

1) Leia e processe os arquivos.
2) Clique em "Buscar Usuário Por ID".
3) Digite a ID do usuário sem o domínio e clique em "Buscar".
5) Caso a ID seja válida, uma nova janela abrirá com os dados do usuário buscado. Caso contrário, o usuário não existe ou a ID foi inserida incorretamente.

-> Filtrando atividades por data

1) Leia e processe os arquivos.
2) Clique em "Filtrar Atividades Por Data".
3) Defina se você deseja visualizar as atividades por dia ou periodo.
4) Clique na opção desejada e insira a ID do usuário sem o domínio e insira a(s) data(s) desejada(s) no formato: dd/mm/aaaa.
5) Caso as opções digitadas sejam válidas, uma janela abrirá com todos os dados da atividade. Caso contrário, não existem atividades para o periodo escolhido e o usuário é considerado
   suspeito.
  
-> Listando usuários suspeitos

1) Leia e processe os arquivos.
2) Clique em Listar Usuários Supeitos.
3) Uma janela com uma lista de todos usuários considerados suspeitos abrirá.
   

   
How to use the system:

To use the application it is necessary to first open the files to be read, they should be: A file referring to the list of users and their attributes, with extension
.CSV and a file referring to the list of activities of the users, as well, their respective attributes. If the files have not been opened and read primarily, the other features
Will not work correctly because there is no data to read.

-> Reading and processing the files:

1) Click "Open and Process Files".
2) Enter the users' file directory in the first text field.
3) Enter the file directory of the users' activities in the second text field.
4) Click OK
5) You will receive a success message if the files are read correctly. Otherwise, close the open window, check the file path, and try again.
   File path example: /home/yourName/Documents/Archives/ldap.csv
   
-> Searching and viewing users by ID:

1) Read and process the files.
2) Click "Search User By ID".
3) Enter the user ID without the domain and click "Search".
5) If the ID is valid, a new window will open with the data of the searched user. Otherwise, the user does not exist or the ID was entered incorrectly.

-> Filtering activities by date

1) Read and process the files.
2) Click "Filter Activities By Date".
3) Set whether you want to view activities by day or period.
4) Click the desired option and enter the user ID without the domain and enter the desired date (s) in the format: dd / mm / yyyy.
5) If the options entered are valid, a window will open with all activity data. Otherwise, there are no activities for the chosen period and the user is considered
   suspect.
  
-> Listening to suspicious users

1) Read and process the files.
2) Click on List Hot Users.
3) A window with a list of all users considered suspicious will open.
