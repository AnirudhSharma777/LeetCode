/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        
        if(left == right || head == NULL){
            return head;
        }
        
        ListNode* dummy = new ListNode(0) ;
        
        dummy->next = head;
                
        ListNode* pre = dummy ;
        ListNode* post = dummy ;
        
        for(int i = 1; i<=right+1; i++){
            if(i<left) 
                pre = pre->next;
            post = post->next;
        }
        
        ListNode *start = pre->next;
        ListNode *end = post;
        ListNode* Next = NULL;
        while(start != post){
            Next = start->next;
            start->next = end;
            end = start;
            start = Next;
        }
        
        pre->next = end;
        return dummy->next;
        
        
    }
};