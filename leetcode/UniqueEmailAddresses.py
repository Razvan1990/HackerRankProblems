'''
Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.

For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.

For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.

For example, "m.y+name@email.com" will be forwarded to "my@email.com".
It is possible to use both of these rules at the same time.

Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.



Example 1:

Input: emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
Output: 2
Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
Example 2:

Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
Output: 3


Constraints:

1 <= emails.length <= 100
1 <= emails[i].length <= 100
emails[i] consist of lowercase English letters, '+', '.' and '@'.
Each emails[i] contains exactly one '@' character.
All local and domain names are non-empty.
Local names do not start with a '+' character.
Domain names end with the ".com" suffix.
Domain names must contain at least one character before ".com" suffix.
'''
import email


class Solution:
    def numUniqueEmails(self, emails: list[str]) -> int:
        list_mails = []
        for mail in emails:
            destination_mail = self.get_mail_forwarded(mail)
            list_mails.append(destination_mail)
        #use a set
        unique_mails = set(list_mails)
        print(unique_mails)
        return len(unique_mails)

    def get_mail_forwarded(self, mail:str) -> str:
        local_name = mail.split('@')[0]
        domain_name = mail.split('@')[1]
        if "+" in local_name:
            local_name_send= local_name.split('+')[0]
        else:
            local_name_send = local_name
        local_name_final = local_name_send.replace(".","")
        mail_sent = local_name_final +"@"+domain_name
        return mail_sent

if __name__ == '__main__':
    emails = ["test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"]
    emails2 = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]

    print(Solution().numUniqueEmails(emails))
    print(Solution().numUniqueEmails(emails2))





