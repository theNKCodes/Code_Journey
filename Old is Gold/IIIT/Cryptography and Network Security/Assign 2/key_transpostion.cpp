#include <bits/stdc++.h>
using namespace std;
string transpositionEncrypt(string &text, string &key)
{

    int i, j;
    int cols = key.length();
    int rows = (text.length() / cols) + ((text.length() % cols) != 0);

    char arr[rows][cols];
    map<char, int> keyMap;
    for (i = 0; i < cols; i++)
    {
        keyMap[key[i]] = i;
    }
    int index = 0;
    char c = 'a';
    for (i = 0; i < rows; i++)
    {
        for (j = 0; j < cols;)
        {
            if (text[index] == '\0')
            {
                arr[i][j] = c;
                c++;
                j++;
            }
            else if (isalpha(text[index]) || text[index] == ' ')
            {
                arr[i][j] = text[index];
                j++;
            }
            index++;
        }
    }
    string result = "";

    for (auto it = keyMap.begin(); it != keyMap.end(); it++)
    {
        j = it->second;
        for (i = 0; i < rows; i++)
        {
            result += arr[i][j];
        }
    }

    return result;
}

int main()
{
    string plainText, cypertext, c, x;
    string key = "nikhlbwtameojpqrcxudsfvyzg 0123456789";
    getline(cin, plainText);
    cout<< transpositionEncrypt(plainText, key);
}