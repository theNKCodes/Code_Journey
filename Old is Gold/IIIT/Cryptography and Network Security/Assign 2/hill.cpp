#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <algorithm>
using namespace std;

vector<vector<string>> k = {
    {"n", "i", "k", "h", "l"},
    {"b", "w", "t", "a", "m"},
    {"e", "o", "j", "p", "q"},
    {"r", "c", "x", "u", "d"},
    {"s", "f", "v", "y", "z"}};

string encrypt(string p)
{
    string ct;
    for (int i = 0; i < 5; i++)
    {
        int sum = 0;
        for (int j = 0; j < 5; j++)
        {
            sum += (int)(p[j] -'a') * (int)(k[j][i][0] -'a');
        }
        char encrypted_char = 'a' + (sum  % 26);
        ct += encrypted_char;
    }
    return ct;
}

string toUpperCase(const string &str)
{
    string result;
    for (char c : str)
    {
        result += toupper(c);
    }
    return result;
}

string getNextFiveChars(const string &input)
{
    static int currentIndex = 0;
    string output;

    for (int i = currentIndex; i < currentIndex + 5 && i < input.length(); i++)
    {
        output += input[i];
    }

    currentIndex += 5;

    return output;
}

int main()
{

    string pt = "cryptography and network security";
    string ct;

    pt.erase(remove(pt.begin(), pt.end(), ' '), pt.end());

    for (int i = 0; i < pt.length(); i += 5)
    {
        string pt_break = getNextFiveChars(pt);
        ct += encrypt(pt_break);
    }
    
    string upper_ct = toUpperCase(ct);
    cout << upper_ct << '\n';
    return 0;
}
