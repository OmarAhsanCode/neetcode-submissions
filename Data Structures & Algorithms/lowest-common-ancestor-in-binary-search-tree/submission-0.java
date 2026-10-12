/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public List<TreeNode> ancestors(TreeNode root, TreeNode p)
    {
        List<TreeNode> arr = new ArrayList<>();
        if(root==null)
        {
            return arr;
        }
        if(root==p)
        {
            arr.add(root);
            return arr;
        }
        List<TreeNode> left = ancestors(root.left, p);

        if (!left.isEmpty()) {
            arr.add(root);
            arr.addAll(left);
            return arr;
        }

        List<TreeNode> right = ancestors(root.right, p);

        if (!right.isEmpty()) {
            arr.add(root);
            arr.addAll(right);
        }
        return arr;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> arrp= ancestors(root,p);
        List<TreeNode> arrq= ancestors(root,q);

        HashSet<TreeNode> set=new HashSet<TreeNode>();
        for(int i=0;i<arrp.size();i++)
        {
            set.add(arrp.get(i));
        }
        for(int i=arrq.size()-1;i>=0;i--)
        {
            if(set.contains(arrq.get(i))){
                return arrq.get(i);
            }
        }
        return null;
    }
}
