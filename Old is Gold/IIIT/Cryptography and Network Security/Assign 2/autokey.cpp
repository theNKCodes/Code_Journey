#include <iostream>
#include <string>
#include <map>
using namespace std;

string encrypt(string pt, int key, map<string, int> &table)
{
    string ct;
    map<string, int>::iterator iter;
    int ptvalue[pt.length()];
    for (int i = 0; i < pt.length(); i++)
    {
        ptvalue[i] = 0;
        for (iter = table.begin(); iter != table.end(); iter++)
        {
            if (iter->first == string(1, pt[i]))
            {
                ptvalue[i] += iter->second;
                break;
            }
        };
    }
    int keystream[pt.length()];
    keystream[0] = key;
    for (int i = 1; i < pt.length(); i++)
    {
        keystream[i] = ptvalue[i - 1];
    }
    int cvalues[pt.length()];
    for (int i = 0; i < pt.length(); i++)
    {
        cvalues[i] = (keystream[i] + ptvalue[i]) % 26;
    }
    for (int i = 0; i < pt.length(); i++)
    {
        for (iter = table.begin(); iter != table.end(); iter++)
        {
            if (iter->second == cvalues[i])
            {
                ct += iter->first;
                break;
            }
        };
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

int main()
{
    int k_roll1 = 1;
    int k_roll2 = 0;
    map<string, int> table;
    for (int i = 0; i <= 10; i++)
    {
        if (i != 10)
        {
            table[to_string(i)] = i;
        }
        table[" "] = 10;
    }

    char letter = 'a';
    for (int i = 11; i <= 36; i++)
    {
        table[string(1, letter)] = i;
        letter++;
    }
    map<string, int>::iterator iter;

    string pt = "cryptography and network security";
    string ct = encrypt(pt, k_roll1, table);
    string upper_ct = toUpperCase(ct);
    cout << upper_ct << '\n';
    return 0;
}