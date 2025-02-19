#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<pair<string, string>> k_trad;
string arr[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
int findElement(string target)
{
    for (int i = 0; i < sizeof(arr) / sizeof(arr[0]); ++i)
    {
        if (arr[i] == target)
        {
            return i;
        }
    }
    return -1;
}
string check_letter(char c, int rotation)
{
    string s(1, c);
    string ct;
    for (const auto &pair : k_trad)
    {
        if (pair.first == s)
        {
            int i = findElement(pair.second);
            int index = i - rotation;
            if (index < 0) index = (sizeof(arr) / sizeof(arr[0])) + index;
            string rotated_char = arr[index].substr(0, 1);
            ct += rotated_char;
            break;
        }
    }
    return ct;
}


int main()
{
    k_trad.push_back({"0", "n"});
    k_trad.push_back({"1", "i"});
    k_trad.push_back({"2", "k"});
    k_trad.push_back({"3", "h"});
    k_trad.push_back({"4", "l"});
    k_trad.push_back({"5", "b"});
    k_trad.push_back({"6", "w"});
    k_trad.push_back({"7", "t"});
    k_trad.push_back({"8", "a"});
    k_trad.push_back({"9", "m"});
    k_trad.push_back({" ", "e"});
    k_trad.push_back({"a", "o"});
    k_trad.push_back({"b", "j"});
    k_trad.push_back({"c", "p"});
    k_trad.push_back({"d", "q"});
    k_trad.push_back({"e", "r"});
    k_trad.push_back({"f", "c"});
    k_trad.push_back({"g", "x"});
    k_trad.push_back({"h", "u"});
    k_trad.push_back({"i", "d"});
    k_trad.push_back({"j", "s"});
    k_trad.push_back({"k", "f"});
    k_trad.push_back({"l", "v"});
    k_trad.push_back({"m", "y"});
    k_trad.push_back({"n", "z"});
    k_trad.push_back({"o", "g"});
    k_trad.push_back({"p", " "});
    k_trad.push_back({"q", "0"});
    k_trad.push_back({"r", "1"});
    k_trad.push_back({"s", "2"});
    k_trad.push_back({"t", "3"});
    k_trad.push_back({"u", "4"});
    k_trad.push_back({"v", "5"});
    k_trad.push_back({"w", "6"});
    k_trad.push_back({"x", "7"});
    k_trad.push_back({"y", "8"});
    k_trad.push_back({"z", "9"});

    for (int i = 0; i < k_trad.size(); i++)
    {
        cout << k_trad[i].first << " " << k_trad[i].second << endl;
    }

    string pt = "cryptography";
    string ct;
    for (int i = 0; i < pt.length(); i++)
    {
        ct += check_letter(pt[i], i);
    }

    cout << "Plaintext: " << pt << endl;
    cout << "Ciphertext: " << ct << endl;

    return 0;
}
