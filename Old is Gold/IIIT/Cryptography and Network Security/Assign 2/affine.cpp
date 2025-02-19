// Affine Cipher <-- Substitution Technique
// P.T. Letters are replaced by other letters or symbols.
// Algorithm: For each plaintext letter 'p', substitute the ciphertext letter 't'
//  then for each 't', substitute ciphertext letter 'ct':
// T = E (p, k1) mod 26 = (p + k1) mod 26
// C = E (t, k2) mod 26 = (t + k2) mod 26

#include <iostream>
#include <string>
#include <map>
using namespace std;

string encryptk1(string pt, int key, map<string, int> &table)
{
    string ct;
    map<string, int>::iterator iter;
    for (int i = 0; i < pt.length(); i++)
    {
        int valueToCheck = (int(pt[i]) + key) % 26;
        for (iter = table.begin(); iter != table.end(); iter++)
        {
            if (iter->second == valueToCheck)
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
    string t = encryptk1(pt, k_roll1, table);
    string ct = encryptk1(t, k_roll2, table);
    string upper_ct = toUpperCase(ct);
    cout << upper_ct << '\n';
    return 0;
}