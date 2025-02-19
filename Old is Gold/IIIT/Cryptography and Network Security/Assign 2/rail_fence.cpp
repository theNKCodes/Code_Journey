#include <bits/stdc++.h>
using namespace std;

int main()
{
    string pt = "cryptography and network security";
    pt.erase(remove(pt.begin(), pt.end(), ' '), pt.end());
    cout<<pt<<endl;

    string ct;
    string tmp;
    for (int i = 0; i < pt.length(); i += 2)
    {
        ct += pt[i];
        tmp += pt[i + 1];
    }
    ct += tmp;
    cout<<ct<<endl;
    return 0;
}